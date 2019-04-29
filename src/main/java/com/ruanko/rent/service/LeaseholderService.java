package com.ruanko.rent.service;

import com.ruanko.rent.dao.LeaseholderDao;
import com.ruanko.rent.entity.Leaseholder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LeaseholderService Class
 *
 * @author zhangjianyun
 * @date 2018-9-25
 */
@Service
public class LeaseholderService {
    @Autowired
    private LeaseholderDao leaseholderDao;

    public List<Leaseholder> getLeaseholderList(){
        return leaseholderDao.getAll();
    }

    public Leaseholder findLeaseholderById(String id){
        return  leaseholderDao.getOne(id);
    }

    public void save(Leaseholder leaseholder) {
        leaseholderDao.insert(leaseholder);
    }

    public void edit(Leaseholder leaseholder){
        leaseholderDao.update(leaseholder);
    }

    public void delete(String id) {
        leaseholderDao.delete(id);
    }
}
