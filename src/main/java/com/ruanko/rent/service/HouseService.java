package com.ruanko.rent.service;

import com.ruanko.rent.dao.HouseDao;
import com.ruanko.rent.entity.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * HouseService Class
 *
 * @author zhangjianyun
 * @date 2018-9-27
 */
@Service
public class HouseService {
    @Autowired
    private HouseDao houseDao;

    public List<House> getHouseList(){
        return houseDao.getAll();
    }

    public House findHouseById(int id){
        return  houseDao.getOne(id);
    }

    public void save(House house) {
        houseDao.insert(house);
    }

    public void edit(House house){
        houseDao.update(house);
    }

    public void delete(int id) {
        houseDao.delete(id);
    }
}
