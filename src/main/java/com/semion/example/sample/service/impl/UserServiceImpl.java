package com.semion.example.sample.service.impl;

import com.semion.example.sample.dao.UserPoMapper;
import com.semion.example.sample.domain.UserPo;
import com.semion.example.sample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by heshuanxu on 2018/7/30.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPoMapper userPoMapper;

    //  spring会对unchecked异常进行事务回滚；如果是checked异常则不回滚 如果我想check异常也想回滚怎么办，注解上面写明异常类型即可。
    // @Transactional(rollbackFor=Exception.class)

    @Transactional(propagation = Propagation.REQUIRED,isolation = Isolation.DEFAULT)
    @Override
    public String insert(UserPo userPo) {
        log.info("service insert log =====================");
        userPoMapper.insert(userPo);
        int i = 10 / 0;// 发生异常事物回滚
        log.info(i+"");
        return "success";
    }
}
