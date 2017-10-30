package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblBxnumTempMapper;
import com.papabear.sso.dao.model.TblBxnumTemp;
import com.papabear.sso.dao.model.TblBxnumTempExample;
import com.papabear.sso.rpc.api.TblBxnumTempService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblBxnumTempService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblBxnumTempServiceImpl extends BaseServiceImpl<TblBxnumTempMapper, TblBxnumTemp, TblBxnumTempExample> implements TblBxnumTempService {

    private static Logger _log = LoggerFactory.getLogger(TblBxnumTempServiceImpl.class);

    @Autowired
    TblBxnumTempMapper tblBxnumTempMapper;

}