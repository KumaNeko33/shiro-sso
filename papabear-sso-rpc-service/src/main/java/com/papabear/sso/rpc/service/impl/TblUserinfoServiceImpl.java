package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblUserinfoMapper;
import com.papabear.sso.dao.model.TblUserinfo;
import com.papabear.sso.dao.model.TblUserinfoExample;
import com.papabear.sso.rpc.api.TblUserinfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblUserinfoService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblUserinfoServiceImpl extends BaseServiceImpl<TblUserinfoMapper, TblUserinfo, TblUserinfoExample> implements TblUserinfoService {

    private static Logger _log = LoggerFactory.getLogger(TblUserinfoServiceImpl.class);

    @Autowired
    TblUserinfoMapper tblUserinfoMapper;

}