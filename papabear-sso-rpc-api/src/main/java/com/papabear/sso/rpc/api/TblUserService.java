package com.papabear.sso.rpc.api;

import com.papabear.commons.base.BaseService;
import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.dao.model.TblUserExample;

/**
* TblUserService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblUserService extends BaseService<TblUser, TblUserExample> {

    /**
     * 创建账号
     * @author yaoweiguo
     * @date 2016年6月22日
     * @param userName		用户名
     * @param password		密码
     * @param ip			访问ip地址
     * @param origin		来源
     * @return
     */
    Long createAccount(String userName, String password, String ip, Byte origin);

    /**
     * 创建账号
     * @author yaoweiguo
     * @date 2016年6月22日
     * @param userName		账号
     * @param password		密码
     * @param ip			访问ip地址
     * @param origin		来源
     * @param inviteCode	邀请码
     * @return
     */
    Long createAccount(String userName, String password, String ip, Byte origin, String inviteCode);

    /**
     * 密码重置
     * @author yaoweiguo
     * @date 2016年6月24日
     * @param userName
     * @param password
     * @return
     */
    int updatePassword(String userName, String password);

    /**
     * 第三方登录创建用户信息
     * @author yaoweiguo
     * @date 2016年6月27日
     * @param avatarImg			头像
     * @param nickName			昵称
     * @param sex				性别
     * @param ip				登录ip
     * @return
     */
    TblUser createOtherLoginUser(String avatarImg, String nickName, String sex, String ip);


    /**
     * 获取用户信息
     * @author yaoweiguo
     * @date 2016年6月24日
     * @param userName		登录账号
     * @return
     */
    TblUser getUser(String userName);

    /**
     *
     * @author yaoweiguo
     * @date 2016年6月27日
     * @param id
     * @return
     */
    TblUser getUser(Long id);

    /**
     * 获取加密后的密码
     * @author yaoweiguo
     * @date 2016年6月24日
     * @param password		密码
     * @param salt			随机数
     * @return
     */
    String getMd5Password(String password, String salt);

    /**
     * 授权
     * @author yaoweiguo
     * @date 2016年6月21日
     * @return
     */
    int authorise();

    //新
    TblUser createUser(TblUser user);
}