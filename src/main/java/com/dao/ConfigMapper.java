package com.dao;

import com.entity.Config;

import java.util.List;

public interface ConfigMapper {
    int insert(Config record);

    int insertSelective(Config record);

    List<Config> selectOption();
}