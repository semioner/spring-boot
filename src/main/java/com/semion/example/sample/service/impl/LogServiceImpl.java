package com.semion.example.sample.service.impl;

import com.semion.example.sample.dao.SysLogMapper;
import com.semion.example.sample.domain.SysLog;
import com.semion.example.sample.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public  class LogServiceImpl implements LogService {

    @Autowired
    private SysLogMapper sysLogMapper;

    @Override
    public void saveLog(SysLog log) {
        sysLogMapper.insert(log);
    }
}
