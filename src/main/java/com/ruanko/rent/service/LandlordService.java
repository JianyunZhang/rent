package com.ruanko.rent.service;

import com.ruanko.rent.dao.LandlordDao;
import com.ruanko.rent.entity.Landlord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * LandlordService Class
 *
 * @author zhangjianyun
 * @date 2018-9-25
 */
@Service
public class LandlordService {
    @Autowired
    private LandlordDao landlordDao;

    public List<Landlord> getLandlordList(){
        return landlordDao.getAll();
    }

    public Landlord findLandlordById(String id){
        return  landlordDao.getOne(id);
    }

    public void save(Landlord landlord) {
        landlordDao.insert(landlord);
    }

    public void edit(Landlord landlord){
        landlordDao.update(landlord);
    }

    public void delete(String id) {
        landlordDao.delete(id);
    }
}
