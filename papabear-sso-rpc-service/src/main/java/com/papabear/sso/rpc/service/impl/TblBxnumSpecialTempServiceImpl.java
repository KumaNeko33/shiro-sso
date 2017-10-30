package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblBxnumSpecialTempMapper;
import com.papabear.sso.dao.model.TblBxnumSpecialTemp;
import com.papabear.sso.dao.model.TblBxnumSpecialTempExample;
import com.papabear.sso.rpc.api.TblBxnumSpecialTempService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblBxnumSpecialTempService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblBxnumSpecialTempServiceImpl extends BaseServiceImpl<TblBxnumSpecialTempMapper, TblBxnumSpecialTemp, TblBxnumSpecialTempExample> implements TblBxnumSpecialTempService {

    private static Logger _log = LoggerFactory.getLogger(TblBxnumSpecialTempServiceImpl.class);

    @Autowired
    TblBxnumSpecialTempMapper tblBxnumSpecialTempMapper;

}