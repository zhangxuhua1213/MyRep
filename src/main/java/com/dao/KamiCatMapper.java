package com.dao;

import com.entity.KamiCat;

public interface KamiCatMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(KamiCat record);

    int insertSelective(KamiCat record);

    KamiCat selectByName(String name);

    int updateByPrimaryKeySelective(KamiCat record);

    int updateByPrimaryKey(KamiCat record);
}