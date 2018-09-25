package com.service;

import com.dao.KamilistMapper;
import com.entity.Kamilist;
import com.result.KamiUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KamilistService {
    @Autowired
    private KamilistMapper kamilistMapper;

    public  List<KamiUser> selectKamiListAndUser(Long userid){
        return kamilistMapper.selectKamiListAndUser(userid);
    }

    public Integer insertKamilist(Kamilist kamilist){
        return kamilistMapper.insertKamilist(kamilist);
    }
}
