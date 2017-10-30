package com.papabear.sso.dao.mapper;

import com.papabear.sso.dao.model.TblUser;
import com.papabear.sso.dao.model.TblUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblUserMapper {

    /**
     * 根据账号查询总记录数
     * @param phone  手机号
     * @return count
     */
    int queryUsersCountByPhone(String phone);

    /**
     * 检查是否有该用户
     * @author yaoweiguo
     * @date 2016年6月22日
     * @param bxNum			白熊号，邀请码
     * @return
     */
    TblUser getUserByBxNum(String bxNum);

    /**
     * 获取用户信息
     * @author yaoweiguo
     * @date 2016年6月24日
     * @param userName		手机账号
     * @return
     */
    TblUser getUserByUserName(String userName);

    //新
    long countByExample(TblUserExample example);

    int deleteByExample(TblUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    List<TblUser> selectByExample(TblUserExample example);

    TblUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByExample(@Param("record") TblUser record, @Param("example") TblUserExample example);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}