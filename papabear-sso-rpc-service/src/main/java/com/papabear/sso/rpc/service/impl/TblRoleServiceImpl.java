package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblRoleMapper;
import com.papabear.sso.dao.model.TblRole;
import com.papabear.sso.dao.model.TblRoleExample;
import com.papabear.sso.rpc.api.TblRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblRoleService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblRoleServiceImpl extends BaseServiceImpl<TblRoleMapper, TblRole, TblRoleExample> implements TblRoleService {

    private static Logger _log = LoggerFactory.getLogger(TblRoleServiceImpl.class);

    @Autowired
    TblRoleMapper tblRoleMapper;

}