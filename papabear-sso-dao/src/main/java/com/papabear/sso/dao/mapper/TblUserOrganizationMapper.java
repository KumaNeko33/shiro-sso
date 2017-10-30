package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblUserOrganization;
import com.papabear.sso.dao.model.TblUserOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserOrganizationMapper {
    long countByExample(TblUserOrganizationExample example);

    int deleteByExample(TblUserOrganizationExample example);

    int deleteByPrimaryKey(Integer userOrganizationId);

    int insert(TblUserOrganization record);

    int insertSelective(TblUserOrganization record);

    List<TblUserOrganization> selectByExample(TblUserOrganizationExample example);

    TblUserOrganization selectByPrimaryKey(Integer userOrganizationId);

    int updateByExampleSelective(@Param("record") TblUserOrganization record, @Param("example") TblUserOrganizationExample example);

    int updateByExample(@Param("record") TblUserOrganization record, @Param("example") TblUserOrganizationExample example);

    int updateByPrimaryKeySelective(TblUserOrganization record);

    int updateByPrimaryKey(TblUserOrganization record);
}