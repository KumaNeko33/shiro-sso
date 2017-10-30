package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblGrade;
import com.papabear.sso.dao.model.TblGradeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblGradeMapper {
    long countByExample(TblGradeExample example);

    int deleteByExample(TblGradeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TblGrade record);

    int insertSelective(TblGrade record);

    List<TblGrade> selectByExample(TblGradeExample example);

    TblGrade selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TblGrade record, @Param("example") TblGradeExample example);

    int updateByExample(@Param("record") TblGrade record, @Param("example") TblGradeExample example);

    int updateByPrimaryKeySelective(TblGrade record);

    int updateByPrimaryKey(TblGrade record);
}