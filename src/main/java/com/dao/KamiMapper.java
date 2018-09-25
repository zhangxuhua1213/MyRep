package com.dao;

import com.entity.Kami;
import com.result.ActiveRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface KamiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Kami record);

    int insertSelective(Kami record);

    Kami selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Kami record);

    int updateByPrimaryKey(Kami record);

    List<ActiveRecord> getActiveRecord(@Param("id") Long userId,@Param("start") Integer start,@Param("limit") Integer limit,@Param("keyword")String keyword);//通过当前用户获取激活记录，分页

    Integer getActiveRecordCount(@Param("id")Long userId,@Param("keyword")String keyword);//通过当前用户获取激活记录总数

    List<Kami> getListKamiByKid(Integer kid);
}