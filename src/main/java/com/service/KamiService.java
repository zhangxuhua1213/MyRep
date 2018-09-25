package com.service;

import com.dao.KamiMapper;
import com.entity.Kami;
import com.result.ActiveRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
public class KamiService {
    @Autowired
    private KamiMapper kamiMapper;
    public void insertKami(Kami kami){
        kamiMapper.insertSelective(kami);
    }

    public List<ActiveRecord> getActiveRecord(Long userid,Integer start,Integer limit,String keyword){
        return kamiMapper.getActiveRecord(userid,start,limit,keyword);
    }
    public Integer getActiveRecordCount(Long userid,String keyword){
        return kamiMapper.getActiveRecordCount(userid,keyword);
    }


    public List<Kami> getListKamiByKid(Integer kid){
        return kamiMapper.getListKamiByKid(kid);
    }
}
