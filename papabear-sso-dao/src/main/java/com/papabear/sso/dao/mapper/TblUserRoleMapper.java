package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblUserRole;
import com.papabear.sso.dao.model.TblUserRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserRoleMapper {
    long countByExample(TblUserRoleExample example);

    int deleteByExample(TblUserRoleExample example);

    int deleteByPrimaryKey(Long userRoleId);

    int insert(TblUserRole record);

    int insertSelective(TblUserRole record);

    List<TblUserRole> selectByExample(TblUserRoleExample example);

    TblUserRole selectByPrimaryKey(Long userRoleId);

    int updateByExampleSelective(@Param("record") TblUserRole record, @Param("example") TblUserRoleExample example);

    int updateByExample(@Param("record") TblUserRole record, @Param("example") TblUserRoleExample example);

    int updateByPrimaryKeySelective(TblUserRole record);

    int updateByPrimaryKey(TblUserRole record);
}