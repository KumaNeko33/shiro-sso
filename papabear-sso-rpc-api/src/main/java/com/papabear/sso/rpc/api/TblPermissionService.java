package com.papabear.sso.rpc.api;

import com.alibaba.fastjson.JSONArray;
import com.papabear.commons.base.BaseService;
import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblPermissionExample;

/**
* TblPermissionService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblPermissionService extends BaseService<TblPermission, TblPermissionExample> {

    JSONArray getTreeByRoleId(Long roleId);

    JSONArray getTreeByUserId(Long usereId, Byte type);
}