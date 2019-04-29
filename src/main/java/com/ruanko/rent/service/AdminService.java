package com.ruanko.rent.service;

import com.ruanko.rent.dao.AdminDao;
import com.ruanko.rent.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AdminService Class
 *
 * @author zhangjianyun
 * @date 2018-9-20
 */
@Service
public class AdminService {
    @Autowired
    private AdminDao adminDao;

    public List<Admin> getAdminList(){
        return adminDao.getAll();
    }

    public Admin findAdminById(String id){
        return  adminDao.getOne(id);
    }

    public void save(Admin admin) {
        adminDao.insert(admin);
    }

    public void edit(Admin admin){
        adminDao.update(admin);
    }

    public void delete(String id) {
        adminDao.delete(id);
    }
}
