package com.dao;

import com.entity.Kamilist;
import com.result.KamiUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KamilistMapper {

    List<KamiUser> selectKamiListAndUser(Long userid);

    int deleteByPrimaryKey(Integer id);

    int insert(Kamilist record);

    int insertSelective(Kamilist record);

   Integer insertKamilist(Kamilist record);
}