package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseServiceInteger;
import com.papabear.commons.base.BaseServiceIntegerImpl;
import com.papabear.sso.dao.mapper.TblGradeMapper;
import com.papabear.sso.dao.model.TblGrade;
import com.papabear.sso.dao.model.TblGradeExample;
import com.papabear.sso.rpc.api.TblGradeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblGradeService实现
*
 * @author miaohongshuai
 * @date 2017/10/19
 */
@Service
@Transactional
@BaseServiceInteger
public class TblGradeServiceImpl extends BaseServiceIntegerImpl<TblGradeMapper, TblGrade, TblGradeExample> implements TblGradeService {

    private static Logger _log = LoggerFactory.getLogger(TblGradeServiceImpl.class);

    @Autowired
    TblGradeMapper tblGradeMapper;

}