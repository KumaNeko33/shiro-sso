package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblSystem;
import com.papabear.sso.dao.model.TblSystemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblSystemMapper {
    long countByExample(TblSystemExample example);

    int deleteByExample(TblSystemExample example);

    int deleteByPrimaryKey(Integer systemId);

    int insert(TblSystem record);

    int insertSelective(TblSystem record);

    List<TblSystem> selectByExample(TblSystemExample example);

    TblSystem selectByPrimaryKey(Integer systemId);

    int updateByExampleSelective(@Param("record") TblSystem record, @Param("example") TblSystemExample example);

    int updateByExample(@Param("record") TblSystem record, @Param("example") TblSystemExample example);

    int updateByPrimaryKeySelective(TblSystem record);

    int updateByPrimaryKey(TblSystem record);
}