package com.ruanko.rent.service;

import com.ruanko.rent.dao.ChecklogDao;
import com.ruanko.rent.entity.Checklog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminService Class
 *
 * @author zhangjianyun
 * @date 2018-9-27
 */
@Service
public class ChecklogService {
    @Autowired
    private ChecklogDao checklogDao;

    public List<Checklog> getChecklogList(){
        return checklogDao.getAll();
    }

    public Checklog findChecklogById(int id){
        return  checklogDao.getOne(id);
    }

    public void save(Checklog checklog) {
        checklogDao.insert(checklog);
    }

    public void edit(Checklog checklog){
        checklogDao.update(checklog);
    }

    public void delete(int id) {
        checklogDao.delete(id);
    }
}
