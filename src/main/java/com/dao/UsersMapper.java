package com.dao;

import com.entity.Users;
import com.result.JifenRecord;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UsersMapper {
    Users checkUserIsRegister(@Param("username") String username,@Param("password") String password);
    Integer getCount(String id);

    List<Users> getUserLsit(@Param("start") Integer start,@Param("limit") Integer limit,@Param("id") String id);

    int insertSelective(Users record);

    Integer getUserCountByInviter(Long id);

    List<Users> getUserListByInviter(Long id);
    void updateMonthcardnumsById(@Param("id")Long id,@Param("monthcardnums")Integer monthcardnums);


    Integer getJifenCount();

    Integer getMothCardNumsById(Long id);

    List<JifenRecord> getJifenRecord(@Param("start") Integer start, @Param("limit") Integer limit);

    int updateByPrimaryKeySelective(Users record);

    Integer getHuiyuanNumById(Long id);
}