package com.service;

import javax.annotation.Resource;

import com.dao.PersistentLoginsMapper;
import com.entity.PersistentLogins;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

@Service
public class PersistentLoginsSercice {
    @Resource
    private PersistentLoginsMapper persistentLoginsMapper;

    public int deleteByPrimaryKey(Integer id) {
        return persistentLoginsMapper.deleteByPrimaryKey(id);
    }

    public int insert(PersistentLogins pLogins) {
        return persistentLoginsMapper.insert(pLogins);
    }

    public int insertSelective(PersistentLogins pLogins) {
        return persistentLoginsMapper.insertSelective(pLogins);
    }


    public PersistentLogins selectByPrimaryKey(Integer id) {
        return persistentLoginsMapper.selectByPrimaryKey(id);
    }

    public int updateByPrimaryKeySelective(PersistentLogins pLogins) {
        return persistentLoginsMapper.updateByPrimaryKeySelective(pLogins);
    }

    public int updateByPrimaryKey(PersistentLogins pLogins) {
        return persistentLoginsMapper.updateByPrimaryKey(pLogins);
    }

    public PersistentLogins selectByUsernameAndSeries(String username, String series) {
        if(StringUtils.isNotBlank(username) && StringUtils.isNotBlank(series))
            return persistentLoginsMapper.selectByUsernameAndSeries(username, series);
        else
            return null;
    }


    public PersistentLogins selectByUsername(String username) {
        return persistentLoginsMapper.selectByUsername(username);
    }
}
