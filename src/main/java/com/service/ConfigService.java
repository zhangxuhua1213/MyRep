package com.service;

import com.dao.ConfigMapper;
import com.entity.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {
    @Autowired
    private ConfigMapper configMapper;
    public List<Config> getSelectOption(){
        return configMapper.selectOption();
    }
}
