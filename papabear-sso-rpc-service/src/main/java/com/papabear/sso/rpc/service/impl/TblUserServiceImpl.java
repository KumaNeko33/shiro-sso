package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.commons.entity.enumentity.Constant;
import com.papabear.commons.exception.PapabearException;
import com.papabear.commons.sign.MD5;
import com.papabear.commons.utils.StringUtils;
import com.papabear.sso.dao.mapper.*;
import com.papabear.sso.dao.model.*;
import com.papabear.sso.rpc.api.TblUserService;
import com.papabear.sso.rpc.exception.UserResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
* TblUserService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblUserServiceImpl extends BaseServiceImpl<TblUserMapper, TblUser, TblUserExample> implements TblUserService {

    private static Logger _log = LoggerFactory.getLogger(TblUserServiceImpl.class);

    @Autowired
    TblUserMapper userMapper;

    @Autowired
    TblUserinfoMapper userinfoMapper;

    @Autowired
    private TblFenxiaoUserInfoMapper fenxiaoUserInfoMapper;

    @Autowired
    private TblBxnumTempMapper bxnumTempMapper;

    @Autowired
    private TblBxnumSpecialTempMapper bxnumSpecialTempMapper;

    private static List<Long> bxNumList = null;

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#createAccount(java.lang.String,
     * java.lang.String)
     */
    @Override
    public Long createAccount(String userName, String password, String ip, Byte origin) {

        return this.createAccount(userName, password, ip, origin, null);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#createAccount(java.lang.String,
     * java.lang.String, java.lang.String)
     */
    @Override
    @Transactional
    public Long createAccount(String userName, String password, String ip, Byte origin, String inviteCode) {
//		check(userName, password);
        Long userId = createUser(userName, password, ip);
        if (StringUtils.isNotBlank(inviteCode)) {
            TblUser user = userMapper.getUserByBxNum(inviteCode);
            if (user != null) {
                this.createFenxiaoUserInfo(user.getId(), userId, origin);
            } else {
                this.createFenxiaoUserInfo(null, userId, origin);
            }
        } else {
            this.createFenxiaoUserInfo(null, userId, origin);
        }
        return userId;
    }

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#authorise()
     */
    @Override
    public int authorise() {
        // TODO Auto-generated method stub
        return 0;
    }

//	/** 校验账号信息 */
//	private void check(String userName, String password) {
//		if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
//			throw new PapabearException(UserResultCode.DATA_BLANK, null);
//		}
//		if (!StringUtils.isMobileFormat(userName)) {
//			throw new PapabearException(UserResultCode.MOBILE_FORMAT_ERROR, null);
//		}
//		if (password.length() < 6 || password.length() > 16) {
//			throw new PapabearException(UserResultCode.PASSWORD_LENGTH_ERROR, null);
//		}
//		if (userMapper.queryUsersCountByPhone(userName) > 0) {
//			throw new PapabearException(UserResultCode.ACCOUNT_EXIST_ERROR, null);
//		}
//	}

    /** 保存数据 */
    private Long createUser(String userName, String password, String ip) {
        TblUser user = new TblUser();
        Random random = new Random();
        String salt = String.valueOf(random.nextInt(10000));
        user.setPhone(userName);
        user.setUserName(userName);
        user.setSalt(salt);
        password = MD5.MD5Encode(MD5.MD5Encode(password + salt));
        user.setUserPwd(password);
        user.setCreateDateTime(new Date());
        user.setUpdateTime(new Date());
        user.setExpNum(0);
        user.setStatus(Constant.Status.NORMAL.getStatus());
        user.setPoints(0);
        user.setGradeId(1);
        user.setAvailable(Constant.Status.NORMAL.getStatus());
        user.setAvatarImg(createRandomAvatarImg());
        user.setBxNum(getBxNum());
        userMapper.insert(user);
        // userMapper.updateByPrimaryKeySelective(user);
        TblUserinfo userinfo = new TblUserinfo();
        userinfo.setLastIp(ip);
        userinfo.setCreateDateTime(new Date());
        userinfo.setUserId(user.getId());
//        userinfo.setStatus(Constant.Status.NORMAL.getStatus());
        userinfoMapper.insert(userinfo);
        return user.getId();
    }

    /** 创建分销用户信息 */
    private void createFenxiaoUserInfo(Long introducerId, Long userId, Byte origin) {
        TblFenxiaoUserInfo info = new TblFenxiaoUserInfo();
        info.setCreateDateTime(new Date());
        if (introducerId != null) {
            info.setIntroducerId(introducerId);
            info.setIsSuperior((byte) 1);
        }
        info.setOrigin(origin);
        info.setUserId(userId);
        fenxiaoUserInfoMapper.insertSelective(info);
    }

    /**
     * 随机生成白熊号 规则：id+2位随机码
     *
     * @param id
     * @return
     */
    // private String createRandomBxNum(Long id) {
    // Random random = new Random();
    // String num = String.valueOf(id) + String.valueOf(random.nextInt(90) +
    // 10);
    // return num;
    // }

    /**
     * 随机生成一个头像
     *
     * @return
     */
    private String createRandomAvatarImg() {
        Random random = new Random();
        return String.format("http://image.ibaixiong.com/default_user_image/%s.png", random.nextInt(4) + 1);
    }

    /** 获取随机邀请码 */
    public synchronized String getBxNum() {
        long start = System.currentTimeMillis();
        if (bxNumList == null) {
            bxNumList = bxnumTempMapper.queryAllBxNumTempS();
            int length = 4;
            if (bxNumList == null || bxNumList.size() == 0) {
                this.addValidNumber(length);
                bxNumList = bxnumTempMapper.queryAllBxNumTempS();
            }
        }
        if (bxNumList != null && bxNumList.size() < 100) {
            int length = bxNumList.get(bxNumList.size() - 1).toString().length() + 1;
            this.addValidNumber(length);
            bxNumList = bxnumTempMapper.queryAllBxNumTempS();
        }
        Random random = new Random();
        int index = random.nextInt(20);
        Long bxNum = bxNumList.get(index);
        bxNumList.remove(index);
        bxnumTempMapper.deleteByPrimaryKey(bxNum);
        System.out.println(bxNumList.size() + "-----" + (System.currentTimeMillis() - start));
        return bxNum.toString();
    }

    /** 往数据库中分别添加普通和特殊的邀请码 */
    private void addValidNumber(int length) {
        int[] secondNums = { 0, 1, 2, 3, 5, 6, 7, 8, 9 };
        int[] firstNums = { 1, 2, 3, 5, 6, 7, 8, 9 };

        List<String> list = new ArrayList<String>();
        for (int i = 0; i < firstNums.length; i++) {
            permutation(list, String.valueOf(firstNums[i]), secondNums, length - 1);
        }
        List<Long> commonssNums = new ArrayList<Long>();
        List<Long> specialNums = new ArrayList<Long>();
        for (String str : list) {
            if (StringUtils.checkSpecialNumber(str) == 2) {
                // BxnumSpecialTemp bst=new BxnumSpecialTemp();
                // bst.setBxNum(Long.valueOf(str));
                // bxnumSpecialTempMapper.insert(bst);
                specialNums.add(Long.valueOf(str));
            } else {
                // BxnumTemp bt=new BxnumTemp();
                // bt.setBxNum(Long.valueOf(str));
                // bxnumTempMapper.insert(bt);
                commonssNums.add(Long.valueOf(str));
            }
        }
        bxnumTempMapper.insertBath(commonssNums);
        bxnumSpecialTempMapper.insertBath(specialNums);
    }

    /** 排列组合 */
    private void permutation(List<String> list, String s, int[] ia, int n) {
        if (n == 1) {
            for (int i = 0; i < ia.length; i++) {
                // System.out.println(s + ia[i]);
                list.add(s + ia[i]);
            }
        } else {
            for (int i = 0; i < ia.length; i++) {
                String ss = "";
                ss = s + ia[i] + "";
                permutation(list, ss, ia, n - 1);
            }
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#getUser(java.lang.String)
     */
    @Override
    public TblUser getUser(String userName) {

        return userMapper.getUserByUserName(userName);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#getMd5Password(java.lang.String,
     * java.lang.String)
     */
    @Override
    public String getMd5Password(String password, String salt) {

        return MD5.MD5Encode(MD5.MD5Encode(password + salt));
    }

    /*
     * (non-Javadoc)
     *
     * @see com.papabear.user.api.UserService#updatePassword(java.lang.String,
     * java.lang.String)
     */
    @Override
    public int updatePassword(String userName, String password) {
        if (StringUtils.isBlank(userName) || StringUtils.isBlank(password)) {
            throw new PapabearException(UserResultCode.DATA_BLANK, null);
        }
        if (!StringUtils.isMobileFormat(userName)) {
            throw new PapabearException(UserResultCode.MOBILE_FORMAT_ERROR, null);
        }
        if (password.length() < 6 || password.length() > 16) {
            throw new PapabearException(UserResultCode.PASSWORD_LENGTH_ERROR, null);
        }
        if (userMapper.queryUsersCountByPhone(userName) == 0) {
            throw new PapabearException(UserResultCode.ACCOUNT_NOT_EXIST_ERROR, null);
        }
        TblUser user = userMapper.getUserByUserName(userName);
        Random random = new Random();
        String salt = String.valueOf(random.nextInt(10000));
        String newPassword = MD5.MD5Encode(MD5.MD5Encode(password + salt));
        user.setUserPwd(newPassword);
        user.setUpdateTime(new Date());
        user.setSalt(salt);
        userMapper.updateByPrimaryKeySelective(user);
        return 1;
    }

    /*
     * (non-Javadoc)
     *
     * @see
     * com.papabear.user.api.UserService#createOtherLoginUser(java.lang.String,
     * java.lang.String, java.lang.String, java.lang.String)
     */
    @Override
    public TblUser createOtherLoginUser(String avatarImg, String nickName, String sex, String ip) {
        TblUser user = new TblUser();
        user.setBlockTime(new Date());
        user.setAvatarImg(StringUtils.isBlank(avatarImg) ? createRandomAvatarImg() : avatarImg);
        user.setCreateDateTime(new Date());
        user.setUpdateTime(new Date());
        user.setExpNum(0);
        user.setPoints(0);
        user.setGradeId(1);
        user.setBxNum(getBxNum());// 更新白熊号
        user.setNickName(nickName);
        user.setStatus(Constant.Status.NORMAL.getStatus());
        user.setAvailable(Constant.Status.NORMAL.getStatus());
        userMapper.insert(user);

        // 往tbl_user_info插入一条记录，保存用户信息
        TblUserinfo userInfo = new TblUserinfo();
        userInfo.setCreateDateTime(new Date());
        userInfo.setUserId(user.getId());
//        userInfo.setStatus((byte) 1);
        userInfo.setSex(sex);
        userinfoMapper.insertSelective(userInfo);
        return user;
    }

    /* (non-Javadoc)
     * @see com.papabear.user.api.UserService#getuUser(java.lang.Long)
     */
    @Override
    public TblUser getUser(Long id) {
        // TODO Auto-generated method stub
        return userMapper.selectByPrimaryKey(id);
    }

    //新
    @Override
    public TblUser createUser(TblUser upmsUser) {
        TblUserExample upmsUserExample = new TblUserExample();
        upmsUserExample.createCriteria()
                .andUserNameEqualTo(upmsUser.getUserName());
        long count = userMapper.countByExample(upmsUserExample);
        if (count > 0) {
            return null;
        }
        userMapper.insert(upmsUser);
        return upmsUser;
    }
}