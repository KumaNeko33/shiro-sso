package com.papabear.sso.rpc.api;

import com.papabear.sso.dao.model.*;

import java.util.List;

/**
 * sso系统接口
 * Created by miaohongshuai on 2017/10/18.
 */
public interface TblApiService {

    /**
     * 根据用户id获取所拥有的权限(用户和角色权限合集)
     * @param userId
     * @return
     */
    List<TblPermission> selectPermissionByUserId(Long userId);

    /**
     * 根据用户id获取所拥有的权限(用户和角色权限合集)
     * @param userId
     * @return
     */
    List<TblPermission> selectPermissionByUserIdByCache(Long userId);

    /**
     * 根据用户id获取所属的角色
     * @param userId
     * @return
     */
    List<TblRole> selectRoleByUserId(Long userId);
    /**
     * 根据用户id获取所属的角色
     * @param userId
     * @return
     */
    List<TblRole> selectRoleByUserIdByCache(Long userId);

    /**
     * 根据角色id获取所拥有的权限
     * @param roleId
     * @return
     */
    List<TblRolePermission> selectRolePermisstionByRoleId(Long roleId);

    /**
     * 根据用户id获取所拥有的权限
     * @param userId
     * @return
     */
    List<TblUserPermission> selectUserPermissionByUserId(Long userId);

    /**
     * 根据条件获取系统数据
     * @param ssoSystemExample
     * @return
     */
    List<TblSystem> selectSystemByExample(TblSystemExample ssoSystemExample);

    /**
     * 根据条件获取组织数据
     * @param organizationExample
     * @return
     */
    List<TblOrganization> selectOrganizationByExample(TblOrganizationExample organizationExample);

    /**
     * 根据username获取User
     * @param username
     * @return
     */
    TblUser selectUserByUsername(String username);

    /**
     * 写入操作日志
     * @param record
     * @return
     */
    int insertLogSelective(TblLog record);

}
