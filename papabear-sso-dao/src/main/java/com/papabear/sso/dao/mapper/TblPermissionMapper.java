package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblPermission;
import com.papabear.sso.dao.model.TblPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblPermissionMapper {
    long countByExample(TblPermissionExample example);

    int deleteByExample(TblPermissionExample example);

    int deleteByPrimaryKey(Long permissionId);

    int insert(TblPermission record);

    int insertSelective(TblPermission record);

    List<TblPermission> selectByExample(TblPermissionExample example);

    TblPermission selectByPrimaryKey(Long permissionId);

    int updateByExampleSelective(@Param("record") TblPermission record, @Param("example") TblPermissionExample example);

    int updateByExample(@Param("record") TblPermission record, @Param("example") TblPermissionExample example);

    int updateByPrimaryKeySelective(TblPermission record);

    int updateByPrimaryKey(TblPermission record);
}