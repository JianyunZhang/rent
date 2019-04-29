package com.ruanko.rent.service;

import com.ruanko.rent.dao.OrderDao;
import com.ruanko.rent.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * OrderService Class
 *
 * @author zhangjianyun
 * @date 2018-9-27
 */
@Service
public class OrderService {
    @Autowired
    private OrderDao orderDao;

    public List<Order> getOrderList(){
        return orderDao.getAll();
    }

    public Order findOrderById(int id){
        return  orderDao.getOne(id);
    }

    public void save(Order order) {
        orderDao.insert(order);
    }

    public void edit(Order order){
        orderDao.update(order);
    }

    public void delete(int id) {
        orderDao.delete(id);
    }
}
