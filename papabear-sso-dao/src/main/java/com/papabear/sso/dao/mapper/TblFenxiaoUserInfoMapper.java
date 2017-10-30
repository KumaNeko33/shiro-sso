package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblFenxiaoUserInfo;
import com.papabear.sso.dao.model.TblFenxiaoUserInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblFenxiaoUserInfoMapper {
    long countByExample(TblFenxiaoUserInfoExample example);

    int deleteByExample(TblFenxiaoUserInfoExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(TblFenxiaoUserInfo record);

    int insertSelective(TblFenxiaoUserInfo record);

    List<TblFenxiaoUserInfo> selectByExample(TblFenxiaoUserInfoExample example);

    TblFenxiaoUserInfo selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("record") TblFenxiaoUserInfo record, @Param("example") TblFenxiaoUserInfoExample example);

    int updateByExample(@Param("record") TblFenxiaoUserInfo record, @Param("example") TblFenxiaoUserInfoExample example);

    int updateByPrimaryKeySelective(TblFenxiaoUserInfo record);

    int updateByPrimaryKey(TblFenxiaoUserInfo record);
}