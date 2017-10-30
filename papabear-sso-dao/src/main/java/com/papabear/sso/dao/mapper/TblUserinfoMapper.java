package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblUserinfo;
import com.papabear.sso.dao.model.TblUserinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserinfoMapper {
    long countByExample(TblUserinfoExample example);

    int deleteByExample(TblUserinfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblUserinfo record);

    int insertSelective(TblUserinfo record);

    List<TblUserinfo> selectByExample(TblUserinfoExample example);

    TblUserinfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblUserinfo record, @Param("example") TblUserinfoExample example);

    int updateByExample(@Param("record") TblUserinfo record, @Param("example") TblUserinfoExample example);

    int updateByPrimaryKeySelective(TblUserinfo record);

    int updateByPrimaryKey(TblUserinfo record);
}