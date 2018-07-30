package com.semion.example.sample.dao;

import com.semion.example.sample.domain.UserPo;
import com.semion.example.sample.domain.UserPoExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserPoMapper {
    long countByExample(UserPoExample example);

    int deleteByExample(UserPoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserPo record);

    int insertSelective(UserPo record);

    List<UserPo> selectByExample(UserPoExample example);

    UserPo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByExample(@Param("record") UserPo record, @Param("example") UserPoExample example);

    int updateByPrimaryKeySelective(UserPo record);

    int updateByPrimaryKey(UserPo record);
}