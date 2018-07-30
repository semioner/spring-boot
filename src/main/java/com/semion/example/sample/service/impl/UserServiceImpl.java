package com.semion.example.sample.service.impl;

import com.semion.example.sample.dao.UserPoMapper;
import com.semion.example.sample.domain.UserPo;
import com.semion.example.sample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by heshuanxu on 2018/7/30.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPoMapper userPoMapper;

    @Override
    public int insert(UserPo userPo) {
        log.info("service insert =============");
        return userPoMapper.insert(userPo);
    }
}
