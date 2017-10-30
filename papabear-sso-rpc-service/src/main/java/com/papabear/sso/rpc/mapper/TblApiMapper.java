package com.papabear.sso.rpc.mapper;


import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblRole;

import java.util.List;

/**
 * 用户VOMapper
 * Created by shuzheng on 2017/01/07.
 */
public interface TblApiMapper {

	// 根据用户id获取所拥有的权限
	List<TblPermission> selectPermissionByUserId(Long userId);

	// 根据用户id获取所属的角色
	List<TblRole> selectRoleByUserId(Long userId);
	
}