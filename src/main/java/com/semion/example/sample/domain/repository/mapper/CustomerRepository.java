package com.semion.example.sample.domain.repository.mapper;

import com.semion.example.sample.domain.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Mapper
public interface CustomerRepository {

    @Select("SELECT id, name, state, country FROM customer WHERE state = #{state}")
    Customer findByState(String state);
}
