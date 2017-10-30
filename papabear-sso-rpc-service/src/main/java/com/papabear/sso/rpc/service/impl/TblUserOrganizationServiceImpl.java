package com.papabear.sso.rpc.service.impl;

import com.papabear.commons.annotation.BaseServiceInteger;
import com.papabear.commons.base.BaseServiceIntegerImpl;
import com.papabear.sso.dao.mapper.TblUserOrganizationMapper;
import com.papabear.sso.dao.model.TblUserOrganization;
import com.papabear.sso.dao.model.TblUserOrganizationExample;
import com.papabear.sso.rpc.api.TblUserOrganizationService;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblUserOrganizationService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseServiceInteger
public class TblUserOrganizationServiceImpl extends BaseServiceIntegerImpl<TblUserOrganizationMapper, TblUserOrganization, TblUserOrganizationExample> implements TblUserOrganizationService {

    private static Logger _log = LoggerFactory.getLogger(TblUserOrganizationServiceImpl.class);

    @Autowired
    TblUserOrganizationMapper tblUserOrganizationMapper;

    @Override
    public int organization(String[] organizationIds, long id) {
        int result = 0;
        // 删除旧记录
        TblUserOrganizationExample upmsUserOrganizationExample = new TblUserOrganizationExample();
        upmsUserOrganizationExample.createCriteria()
                .andUserIdEqualTo(id);
        tblUserOrganizationMapper.deleteByExample(upmsUserOrganizationExample);
        // 增加新记录
        if (null != organizationIds) {
            for (String organizationId : organizationIds) {
                if (StringUtils.isBlank(organizationId)) {
                    continue;
                }
                TblUserOrganization upmsUserOrganization = new TblUserOrganization();
                upmsUserOrganization.setUserId(id);
                upmsUserOrganization.setOrganizationId(NumberUtils.toInt(organizationId));
                result = tblUserOrganizationMapper.insertSelective(upmsUserOrganization);
            }
        }
        return result;
    }
}