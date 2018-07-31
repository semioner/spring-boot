package com.semion.example.sample.service;

import com.semion.example.sample.domain.UserPo;

import java.util.List;

/**
 * Created by heshuanxu on 2018/7/30.
 */
public interface UserService {

    String insert(UserPo userPo);

    List<UserPo> selectAll(UserPo user);
}
