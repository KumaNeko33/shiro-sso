package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseServiceInteger;
import com.papabear.commons.base.BaseServiceIntegerImpl;
import com.papabear.sso.dao.mapper.TblSystemMapper;
import com.papabear.sso.dao.model.TblSystem;
import com.papabear.sso.dao.model.TblSystemExample;
import com.papabear.sso.rpc.api.TblSystemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblSystemService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseServiceInteger
public class TblSystemServiceImpl extends BaseServiceIntegerImpl<TblSystemMapper, TblSystem, TblSystemExample> implements TblSystemService {

    private static Logger _log = LoggerFactory.getLogger(TblSystemServiceImpl.class);

    @Autowired
    TblSystemMapper tblSystemMapper;

}