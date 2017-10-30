package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseServiceInteger;
import com.papabear.commons.base.BaseServiceIntegerImpl;
import com.papabear.sso.dao.mapper.TblOrganizationMapper;
import com.papabear.sso.dao.model.TblOrganization;
import com.papabear.sso.dao.model.TblOrganizationExample;
import com.papabear.sso.rpc.api.TblOrganizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblOrganizationService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseServiceInteger
public class TblOrganizationServiceImpl extends BaseServiceIntegerImpl<TblOrganizationMapper, TblOrganization, TblOrganizationExample> implements TblOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(TblOrganizationServiceImpl.class);

    @Autowired
    TblOrganizationMapper tblOrganizationMapper;

}