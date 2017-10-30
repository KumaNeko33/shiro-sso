package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblRolePermission;
import com.papabear.sso.dao.model.TblRolePermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblRolePermissionMapper {
    long countByExample(TblRolePermissionExample example);

    int deleteByExample(TblRolePermissionExample example);

    int deleteByPrimaryKey(Long rolePermissionId);

    int insert(TblRolePermission record);

    int insertSelective(TblRolePermission record);

    List<TblRolePermission> selectByExample(TblRolePermissionExample example);

    TblRolePermission selectByPrimaryKey(Long rolePermissionId);

    int updateByExampleSelective(@Param("record") TblRolePermission record, @Param("example") TblRolePermissionExample example);

    int updateByExample(@Param("record") TblRolePermission record, @Param("example") TblRolePermissionExample example);

    int updateByPrimaryKeySelective(TblRolePermission record);

    int updateByPrimaryKey(TblRolePermission record);
}