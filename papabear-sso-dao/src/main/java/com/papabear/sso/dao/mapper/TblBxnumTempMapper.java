package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblBxnumTemp;
import com.papabear.sso.dao.model.TblBxnumTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblBxnumTempMapper {
    long countByExample(TblBxnumTempExample example);

    int deleteByExample(TblBxnumTempExample example);

    int deleteByPrimaryKey(Long bxNum);

    int insert(TblBxnumTemp record);

    int insertSelective(TblBxnumTemp record);

    List<TblBxnumTemp> selectByExample(TblBxnumTempExample example);

    int updateByExampleSelective(@Param("record") TblBxnumTemp record, @Param("example") TblBxnumTempExample example);

    int updateByExample(@Param("record") TblBxnumTemp record, @Param("example") TblBxnumTempExample example);

    //旧
    List<Long> queryAllBxNumTempS();

    int insertBath(List<Long> list);
}