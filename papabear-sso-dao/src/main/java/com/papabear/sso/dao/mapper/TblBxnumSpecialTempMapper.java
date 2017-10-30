package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblBxnumSpecialTemp;
import com.papabear.sso.dao.model.TblBxnumSpecialTempExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblBxnumSpecialTempMapper {
    long countByExample(TblBxnumSpecialTempExample example);

    int deleteByExample(TblBxnumSpecialTempExample example);

    int deleteByPrimaryKey(Long bxNum);

    int insert(TblBxnumSpecialTemp record);

    int insertSelective(TblBxnumSpecialTemp record);

    List<TblBxnumSpecialTemp> selectByExample(TblBxnumSpecialTempExample example);

    int updateByExampleSelective(@Param("record") TblBxnumSpecialTemp record, @Param("example") TblBxnumSpecialTempExample example);

    int updateByExample(@Param("record") TblBxnumSpecialTemp record, @Param("example") TblBxnumSpecialTempExample example);

    //旧
    int insertBath(List<Long> list);
}