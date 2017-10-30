package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblUserPermission;
import com.papabear.sso.dao.model.TblUserPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserPermissionMapper {
    long countByExample(TblUserPermissionExample example);

    int deleteByExample(TblUserPermissionExample example);

    int deleteByPrimaryKey(Long userPermissionId);

    int insert(TblUserPermission record);

    int insertSelective(TblUserPermission record);

    List<TblUserPermission> selectByExample(TblUserPermissionExample example);

    TblUserPermission selectByPrimaryKey(Long userPermissionId);

    int updateByExampleSelective(@Param("record") TblUserPermission record, @Param("example") TblUserPermissionExample example);

    int updateByExample(@Param("record") TblUserPermission record, @Param("example") TblUserPermissionExample example);

    int updateByPrimaryKeySelective(TblUserPermission record);

    int updateByPrimaryKey(TblUserPermission record);
}