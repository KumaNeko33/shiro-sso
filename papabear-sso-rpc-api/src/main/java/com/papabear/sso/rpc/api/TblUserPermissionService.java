package com.papabear.sso.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.papabear.commons.base.BaseService;
import com.papabear.sso.dao.model.TblUserPermission;
import com.papabear.sso.dao.model.TblUserPermissionExample;

/**
* TblUserPermissionService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblUserPermissionService extends BaseService<TblUserPermission, TblUserPermissionExample> {

    /**
     * 用户权限
     * @param datas 权限数据
     * @param id 用户id
     * @return
     */
    int permission(JSONArray datas, long id);
}