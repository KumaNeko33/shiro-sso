package com.papabear.sso.rpc.service.impl;

import com.papabear.sso.dao.mapper.*;
import com.papabear.sso.dao.model.*;
import com.papabear.sso.dao.model.TblSystem;
import com.papabear.sso.rpc.api.TblApiService;
import com.papabear.sso.rpc.mapper.TblApiMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * ApiService实现
 * Created by shuzheng on 2016/01/19.
 */
@Service
@Transactional
public class TblApiServiceImpl implements TblApiService {

    private static Logger _log = LoggerFactory.getLogger(TblApiServiceImpl.class);

    @Autowired
    TblUserMapper userMapper;

    @Autowired
    TblApiMapper tblApiMapper;

    @Autowired
    TblRolePermissionMapper rolePermissionMapper;

    @Autowired
    TblUserPermissionMapper userPermissionMapper;

    @Autowired
    TblSystemMapper ssoSystemMapper;

    @Autowired
    TblOrganizationMapper organizationMapper;

    @Autowired
    TblLogMapper upmsLogMapper;

    /**
     * 根据用户id获取所拥有的权限
     * @param userId
     * @return
     */
    @Override
    public List<TblPermission> selectPermissionByUserId(Long userId) {
        // 用户不存在或锁定状态
        TblUser upmsUser = userMapper.selectByPrimaryKey(userId);
        if (null == upmsUser || 1 != upmsUser.getStatus()) {
            _log.info("selectPermissionByUserId : userId={}", userId);
            return null;
        }
        List<TblPermission> upmsPermissions = tblApiMapper.selectPermissionByUserId(userId);
        return upmsPermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "papabear-sso-rpc-service-ehcache", key = "'selectPermissionByUserId_' + #userId")
    public List<TblPermission> selectPermissionByUserIdByCache(Long userId) {
        return selectPermissionByUserId(userId);
    }

    /**
     * 根据用户id获取所属的角色
     * @param userId
     * @return
     */
    @Override
    public List<TblRole> selectRoleByUserId(Long userId) {
        // 用户不存在或锁定状态
        TblUser upmsUser = userMapper.selectByPrimaryKey(userId);
        if (null == upmsUser || 1 != upmsUser.getStatus()) {
            _log.info("selectRoleByUserId : userId={}", userId);
            return null;
        }
        List<TblRole> upmsRoles = tblApiMapper.selectRoleByUserId(userId);
        return upmsRoles;
    }

    /**
     * 根据用户id获取所属的角色
     * @param userId
     * @return
     */
    @Override
    @Cacheable(value = "papabear-sso-rpc-service-ehcache", key = "'selectRoleByUserId_' + #userId")
    public List<TblRole> selectRoleByUserIdByCache(Long userId) {
        return selectRoleByUserId(userId);
    }

    /**
     * 根据角色id获取所拥有的权限
     * @param roleId
     * @return
     */
    @Override
    public List<TblRolePermission> selectRolePermisstionByRoleId(Long roleId) {
        TblRolePermissionExample upmsRolePermissionExample = new TblRolePermissionExample();
        upmsRolePermissionExample.createCriteria()
                .andRoleIdEqualTo(roleId);
        List<TblRolePermission> upmsRolePermissions = rolePermissionMapper.selectByExample(upmsRolePermissionExample);
        return upmsRolePermissions;
    }

    /**
     * 根据用户id获取所拥有的权限
     * @param userId
     * @return
     */
    @Override
    public List<TblUserPermission> selectUserPermissionByUserId(Long userId) {
        TblUserPermissionExample upmsUserPermissionExample = new TblUserPermissionExample();
        upmsUserPermissionExample.createCriteria()
                .andUserIdEqualTo(userId);
        List<TblUserPermission> upmsUserPermissions = userPermissionMapper.selectByExample(upmsUserPermissionExample);
        return upmsUserPermissions;
    }

    /**
     * 根据条件获取系统数据
     * @param ssoSystemExample
     * @return
     */
    @Override
    public List<TblSystem> selectSystemByExample(TblSystemExample ssoSystemExample) {
        return ssoSystemMapper.selectByExample(ssoSystemExample);
    }

    /**
     * 根据条件获取组织数据
     * @param upmsOrganizationExample
     * @return
     */
    @Override
    public List<TblOrganization> selectOrganizationByExample(TblOrganizationExample upmsOrganizationExample) {
        return organizationMapper.selectByExample(upmsOrganizationExample);
    }

    /**
     * 根据username获取User
     * @param username
     * @return
     */
    @Override
    public TblUser selectUserByUsername(String username) {
        TblUserExample upmsUserExample = new TblUserExample();
        upmsUserExample.createCriteria()
                .andUserNameEqualTo(username);
        List<TblUser> upmsUsers = userMapper.selectByExample(upmsUserExample);
        if (null != upmsUsers && upmsUsers.size() > 0) {
            return upmsUsers.get(0);
        }
        return null;
    }

    /**
     * 写入操作日志
     * @param record
     * @return
     */
    @Override
    public int insertLogSelective(TblLog record) {
        return upmsLogMapper.insertSelective(record);
    }

}