package com.papabear.sso.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.papabear.commons.base.BaseService;
import com.papabear.sso.dao.model.TblRolePermission;
import com.papabear.sso.dao.model.TblRolePermissionExample;

/**
* TblRolePermissionService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblRolePermissionService extends BaseService<TblRolePermission, TblRolePermissionExample> {

    /**
     * 角色权限
     * @param datas 权限数据
     * @param id 角色id
     * @return
     */
    int rolePermission(JSONArray datas, long id);
}