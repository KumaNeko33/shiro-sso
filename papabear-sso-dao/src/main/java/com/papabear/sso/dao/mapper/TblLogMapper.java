package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblLog;
import com.papabear.sso.dao.model.TblLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblLogMapper {
    long countByExample(TblLogExample example);

    int deleteByExample(TblLogExample example);

    int deleteByPrimaryKey(Integer logId);

    int insert(TblLog record);

    int insertSelective(TblLog record);

    List<TblLog> selectByExampleWithBLOBs(TblLogExample example);

    List<TblLog> selectByExample(TblLogExample example);

    TblLog selectByPrimaryKey(Integer logId);

    int updateByExampleSelective(@Param("record") TblLog record, @Param("example") TblLogExample example);

    int updateByExampleWithBLOBs(@Param("record") TblLog record, @Param("example") TblLogExample example);

    int updateByExample(@Param("record") TblLog record, @Param("example") TblLogExample example);

    int updateByPrimaryKeySelective(TblLog record);

    int updateByPrimaryKeyWithBLOBs(TblLog record);

    int updateByPrimaryKey(TblLog record);
}