package com.papabear.sso.rpc.api;

import com.papabear.commons.base.BaseService;
import com.papabear.commons.base.BaseServiceInteger;
import com.papabear.sso.dao.model.TblUserOrganization;
import com.papabear.sso.dao.model.TblUserOrganizationExample;

/**
* TblUserOrganizationService接口
* Created by miaohongshuai on 2017/10/18.
*/
public interface TblUserOrganizationService extends BaseServiceInteger<TblUserOrganization, TblUserOrganizationExample> {

    /**
     * 用户组织
     * @param organizationIds 组织ids
     * @param id 用户id
     * @return
     */
    int organization(String[] organizationIds, long id);
}