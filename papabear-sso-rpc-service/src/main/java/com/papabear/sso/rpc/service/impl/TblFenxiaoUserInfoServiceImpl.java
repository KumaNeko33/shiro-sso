package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblFenxiaoUserInfoMapper;
import com.papabear.sso.dao.model.TblFenxiaoUserInfo;
import com.papabear.sso.dao.model.TblFenxiaoUserInfoExample;
import com.papabear.sso.rpc.api.TblFenxiaoUserInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblFenxiaoUserInfoService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblFenxiaoUserInfoServiceImpl extends BaseServiceImpl<TblFenxiaoUserInfoMapper, TblFenxiaoUserInfo, TblFenxiaoUserInfoExample> implements TblFenxiaoUserInfoService {

    private static Logger _log = LoggerFactory.getLogger(TblFenxiaoUserInfoServiceImpl.class);

    @Autowired
    TblFenxiaoUserInfoMapper tblFenxiaoUserInfoMapper;

}