package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseServiceInteger;
import com.papabear.commons.base.BaseServiceIntegerImpl;
import com.papabear.sso.dao.mapper.TblLogMapper;
import com.papabear.sso.dao.model.TblLog;
import com.papabear.sso.dao.model.TblLogExample;
import com.papabear.sso.rpc.api.TblLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblLogService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseServiceInteger
public class TblLogServiceImpl extends BaseServiceIntegerImpl<TblLogMapper, TblLog, TblLogExample> implements TblLogService {

    private static Logger _log = LoggerFactory.getLogger(TblLogServiceImpl.class);

    @Autowired
    TblLogMapper tblLogMapper;

}