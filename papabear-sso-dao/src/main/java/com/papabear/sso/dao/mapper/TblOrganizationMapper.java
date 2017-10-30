package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblOrganization;
import com.papabear.sso.dao.model.TblOrganizationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrganizationMapper {
    long countByExample(TblOrganizationExample example);

    int deleteByExample(TblOrganizationExample example);

    int deleteByPrimaryKey(Integer organizationId);

    int insert(TblOrganization record);

    int insertSelective(TblOrganization record);

    List<TblOrganization> selectByExample(TblOrganizationExample example);

    TblOrganization selectByPrimaryKey(Integer organizationId);

    int updateByExampleSelective(@Param("record") TblOrganization record, @Param("example") TblOrganizationExample example);

    int updateByExample(@Param("record") TblOrganization record, @Param("example") TblOrganizationExample example);

    int updateByPrimaryKeySelective(TblOrganization record);

    int updateByPrimaryKey(TblOrganization record);
}