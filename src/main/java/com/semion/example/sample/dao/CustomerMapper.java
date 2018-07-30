package com.semion.example.sample.dao;

import com.semion.example.sample.domain.Customer;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by heshuanxu on 2018/7/27.
 */
@Mapper
public interface CustomerMapper {

    Customer findByState(String state);

    List<Customer> getAll();

    Customer getOne(Long id);

    void insert(Customer user);

    void update(Customer user);

    void delete(Long id);
}
