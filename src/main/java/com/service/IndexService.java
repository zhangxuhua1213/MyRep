package com.service;

import com.dao.IndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IndexService {
    @Autowired
    private IndexMapper indexMapper;
    public Integer getTotalRegister(Long id){
        return indexMapper.getTotalRegister(id);
    }
    public Integer getTodayRegisterNums(Long id){
        return indexMapper.getTodayRegisterNums(id);
    }
    public Integer getTodayChargNums(Long id){
        return indexMapper.getTodayChargNums(id);
    }
    public Integer getYestodayRegisterNums(Long id){
        return indexMapper.getYestodayRegisterNums(id);
    }
    public Integer getYestodayChargNums(Long id){
        return indexMapper.getYestodayChargNums(id);
    }
    public Integer getWeekRegisterNums(Long id){
        return indexMapper.getWeekRegisterNums(id);
    }
    public Integer getMonthRegisterNums(Long id){
        return indexMapper.getMonthRegisterNums(id);
    }
}
