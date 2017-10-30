package com.papabear.sso.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblRolePermissionMapper;
import com.papabear.sso.dao.model.TblRolePermission;
import com.papabear.sso.dao.model.TblRolePermissionExample;
import com.papabear.sso.rpc.api.TblRolePermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
* TblRolePermissionService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblRolePermissionServiceImpl extends BaseServiceImpl<TblRolePermissionMapper, TblRolePermission, TblRolePermissionExample> implements TblRolePermissionService {

    private static Logger _log = LoggerFactory.getLogger(TblRolePermissionServiceImpl.class);

    @Autowired
    TblRolePermissionMapper tblRolePermissionMapper;

    @Override
    public int rolePermission(JSONArray datas, long id) {
        List<Long> deleteIds = new ArrayList<>();
        for (int i = 0; i < datas.size(); i ++) {
            JSONObject json = datas.getJSONObject(i);
            if (!json.getBoolean("checked")) {
                deleteIds.add(json.getLongValue("id"));
            } else {
                // 新增权限
                TblRolePermission upmsRolePermission = new TblRolePermission();
                upmsRolePermission.setRoleId(id);
                upmsRolePermission.setPermissionId(json.getLongValue("id"));
                tblRolePermissionMapper.insertSelective(upmsRolePermission);
            }
        }
        // 删除权限
        if (deleteIds.size() > 0) {
            TblRolePermissionExample upmsRolePermissionExample = new TblRolePermissionExample();
            upmsRolePermissionExample.createCriteria()
                    .andPermissionIdIn(deleteIds)
                    .andRoleIdEqualTo(id);
            tblRolePermissionMapper.deleteByExample(upmsRolePermissionExample);
        }
        return datas.size();
    }
}