package com.service;

import com.dao.KamiCatMapper;
import com.entity.KamiCat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KamiCatService {
    @Autowired
    private KamiCatMapper kamiCatMapper;

    public KamiCat getKamiCatByNmae(String cname){
        return kamiCatMapper.selectByName(cname);
    }
}

