package com.papabear.sso.rpc.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.papabear.commons.annotation.BaseService;
import com.papabear.commons.base.BaseServiceImpl;
import com.papabear.sso.dao.mapper.TblUserPermissionMapper;
import com.papabear.sso.dao.model.TblUserPermission;
import com.papabear.sso.dao.model.TblUserPermissionExample;
import com.papabear.sso.rpc.api.TblUserPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
* TblUserPermissionService实现
* Created by miaohongshuai on 2017/10/18.
*/
@Service
@Transactional
@BaseService
public class TblUserPermissionServiceImpl extends BaseServiceImpl<TblUserPermissionMapper, TblUserPermission, TblUserPermissionExample> implements TblUserPermissionService {

    private static Logger _log = LoggerFactory.getLogger(TblUserPermissionServiceImpl.class);

    @Autowired
    TblUserPermissionMapper tblUserPermissionMapper;

    @Override
    public int permission(JSONArray datas, long id) {
        for (int i = 0; i < datas.size(); i ++) {
            JSONObject json = datas.getJSONObject(i);
            if (json.getBoolean("checked")) {
                // 新增权限
                TblUserPermission upmsUserPermission = new TblUserPermission();
                upmsUserPermission.setUserId(id);
                upmsUserPermission.setPermissionId(json.getLongValue("id"));
                upmsUserPermission.setType(json.getByte("type"));
                tblUserPermissionMapper.insertSelective(upmsUserPermission);
            } else {
                // 删除权限
                TblUserPermissionExample upmsUserPermissionExample = new TblUserPermissionExample();
                upmsUserPermissionExample.createCriteria()
                        .andPermissionIdEqualTo(json.getLongValue("id"))
                        .andTypeEqualTo(json.getByte("type"));
                tblUserPermissionMapper.deleteByExample(upmsUserPermissionExample);
            }
        }
        return datas.size();
    }
}