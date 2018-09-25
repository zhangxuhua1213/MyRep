package com.service;

import com.dao.UsersMapper;
import com.entity.Users;
import com.result.JifenRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
   @Autowired
    private UsersMapper userMapper;
    public Long checkUserIsRegister(String username,String password){
        Users user=userMapper.checkUserIsRegister(username,password);
        if(user==null){
            return null;
        }else{
            return user.getId();
        }
    }
    public Integer getCount(Long id){
        return userMapper.getCount(String.valueOf(id));
    }

    public List<Users> getUserLsit(Integer start,Integer limit,Long id){
        return userMapper.getUserLsit(start,limit,String.valueOf(id));
    }

    public void insertUser(Users user){
        userMapper.insertSelective(user);
    }

    public Integer getUserCountByInviter(Long id){
        return userMapper.getUserCountByInviter(id);
    }

    public List<Users> getUserListByInviter(Long id){
        return userMapper.getUserListByInviter(id);
    }


    public Integer getJifenCount(){
        return userMapper.getJifenCount();
    }

    public Integer getMothCardNumsById(Long id){
        return userMapper.getMothCardNumsById(id);
    }

    public List<JifenRecord> getJifenRecord(Integer start,Integer limit){
        return userMapper.getJifenRecord(start,limit);
    }

    public void updateMonthcardnumsById(Long id,Integer monthcardnums){
        userMapper.updateMonthcardnumsById(id,monthcardnums);
    }

    public Integer updateByPrimaryKeySelective(Users user){
            return userMapper.updateByPrimaryKeySelective(user);
    }

    public Integer getHuiyuanNumById(Long id){
        return userMapper.getHuiyuanNumById(id);
    }
}
