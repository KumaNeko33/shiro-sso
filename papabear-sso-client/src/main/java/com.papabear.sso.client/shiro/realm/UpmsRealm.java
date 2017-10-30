package com.papabear.sso.client.shiro.realm;

import com.papabear.commons.sign.MD5;
import com.papabear.commons.util.MD5Util;
import com.papabear.commons.util.PropertiesFileUtil;
import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblRole;
import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.rpc.api.TblApiService;
import com.papabear.sso.rpc.api.TblUserService;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
    * @Description: 用户认证和授权
    * @author: miaohongshuai
    * @Date: 2017/10/19 0019
*/
public class UpmsRealm extends AuthorizingRealm {

    private static Logger _log = LoggerFactory.getLogger(UpmsRealm.class);

    @Autowired
    private TblApiService apiService;

    @Autowired
    private TblUserService userService;

    /**
     * 授权：验证权限时调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        TblUser upmsUser = apiService.selectUserByUsername(username);

        // 当前用户所有角色
        List<TblRole> upmsRoles = apiService.selectRoleByUserId(upmsUser.getId());
        Set<String> roles = new HashSet<>();
        for (TblRole upmsRole : upmsRoles) {
            if (StringUtils.isNotBlank(upmsRole.getName())) {
                roles.add(upmsRole.getName());
            }
        }

        // 当前用户所有权限
        List<TblPermission> upmsPermissions = apiService.selectPermissionByUserId(upmsUser.getId());
        Set<String> permissions = new HashSet<>();
        for (TblPermission upmsPermission : upmsPermissions) {
            if (StringUtils.isNotBlank(upmsPermission.getPermissionValue())) {//没有PermissionValue的是目录
                permissions.add(upmsPermission.getPermissionValue());
            }
        }

        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(permissions);
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    /**
     * 认证：登录时调用
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String username = (String) authenticationToken.getPrincipal();
        String password = new String((char[]) authenticationToken.getCredentials());
        // client无密认证
        String upmsType = PropertiesFileUtil.getInstance("papabear-sso-client").get("papabear.sso.type");
        if ("client".equals(upmsType)) {//判断用户登录时的客户端类型：一般在sso登录的话都为server,为client时无密验证
            return new SimpleAuthenticationInfo(username, password, getName());
        }

        // 查询用户信息
        TblUser upmsUser = apiService.selectUserByUsername(username);

        if (null == upmsUser) {
            throw new UnknownAccountException();
        }
//        if (!upmsUser.getUserPwd().equals(MD5Util.MD5(password + upmsUser.getSalt()))) {
//            throw new IncorrectCredentialsException();
//        }
        if (null == upmsUser.getSalt()) {//没有salt，为sys系统用户
            if (!upmsUser.getUserPwd().equals(MD5Util.encode(password))) {
                throw new IncorrectCredentialsException();
            } else {
                //通过，修改密码加密规则，并加盐：设为Random random = new Random();String salt = String.valueOf(random.nextInt(10000));
                Random random = new Random();
                String salt = String.valueOf(random.nextInt(10000));
                upmsUser.setSalt(salt);
                upmsUser.setUserPwd(MD5.MD5Encode(MD5.MD5Encode(password + salt)));//设置为同tbl_user相同
                userService.updateByPrimaryKeySelective(upmsUser);
            }
        }
        if (!upmsUser.getUserPwd().equals(MD5.MD5Encode(MD5.MD5Encode(password + upmsUser.getSalt())))) {
            throw new IncorrectCredentialsException();
        }
        if (upmsUser.getStatus() != 1) {//0：未激活 1：正常 -1：删除 -2：锁定
            throw new LockedAccountException();
        }

        return new SimpleAuthenticationInfo(username, password, getName());
    }
    /*
    		User user = new User();
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
		user.setGradeId(1l);
		user.setAvailable(Constant.Status.NORMAL.getStatus());
		user.setAvatarImg(createRandomAvatarImg());
		user.setBxNum(getBxNum());
		userDao.insert(user);
     */

}
