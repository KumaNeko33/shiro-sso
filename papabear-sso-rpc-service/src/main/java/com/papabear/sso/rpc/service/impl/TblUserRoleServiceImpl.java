package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblUserRoleMapper;
import com.papabear.sso.dao.model.TblUserRole;
import com.papabear.sso.dao.model.TblUserRoleExample;
import com.papabear.sso.rpc.api.TblUserRoleService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblUserRoleService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblUserRoleServiceImpl extends BaseServiceImpl<TblUserRoleMapper, TblUserRole, TblUserRoleExample> implements TblUserRoleService {

    private static Logger _log = LoggerFactory.getLogger(TblUserRoleServiceImpl.class);

    @Autowired
    TblUserRoleMapper tblUserRoleMapper;

    @Override
    public int role(String[] roleIds, long id) {
        int result = 0;
        // 删除旧记录
        TblUserRoleExample upmsUserRoleExample = new TblUserRoleExample();
        upmsUserRoleExample.createCriteria()
                .andUserIdEqualTo(id);
        tblUserRoleMapper.deleteByExample(upmsUserRoleExample);
        // 增加新记录
        if (null != roleIds) {
            for (String roleId : roleIds) {
                if (StringUtils.isBlank(roleId)) {
                    continue;
                }
                TblUserRole upmsUserRole = new TblUserRole();
                upmsUserRole.setUserId(id);
                upmsUserRole.setRoleId(NumberUtils.toLong(roleId));
                result = tblUserRoleMapper.insertSelective(upmsUserRole);
            }
        }
        return result;
    }
}