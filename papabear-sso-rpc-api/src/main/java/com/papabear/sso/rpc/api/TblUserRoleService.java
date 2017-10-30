package com.papabear.sso.rpc.api;

import com.papabear.commons.base.BaseService;
import com.papabear.sso.dao.model.TblUserRole;
import com.papabear.sso.dao.model.TblUserRoleExample;

/**
* TblUserRoleService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblUserRoleService extends BaseService<TblUserRole, TblUserRoleExample> {

    /**
     * 用户角色
     * @param roleIds 角色ids
     * @param id 用户id
     * @return
     */
    int role(String[] roleIds, long id);
}