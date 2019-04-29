package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao {
    @Select("SELECT * FROM t_order")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "landlord", column = "landlord"),
            @Result(property = "leaseholder", column = "leaseholder"),
            @Result(property = "house", column = "house"),
            @Result(property = "orderdate", column = "orderdate"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "price", column = "price"),
            @Result(property = "state", column = "state")
    })
    List<Order> getAll();

    @Select("SELECT * FROM t_order WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "landlord", column = "landlord"),
            @Result(property = "leaseholder", column = "leaseholder"),
            @Result(property = "house", column = "house"),
            @Result(property = "orderdate", column = "orderdate"),
            @Result(property = "duration", column = "duration"),
            @Result(property = "price", column = "price"),
            @Result(property = "state", column = "state")
    })
    Order getOne(int id);

    @Insert("INSERT INTO t_order(id, landlord, leaseholder, house, orderdate, duration, price, state) VALUES(#{id}, #{landlord}, #{leaseholder}, #{house}, #{orderdate}, #{duration}, #{price}, #{state})")
    void insert(Order order);

    @Update("UPDATE t_order SET id=#{id}, landlord = #{landlord}, leaseholder = #{leaseholder}, house = #{house}, orderdate = #{orderdate}, duration = #{duration}, price = #{price}, state = #{state} WHERE id = #{id}")
    void update(Order order);

    @Delete("DELETE FROM t_order WHERE id = #{id}")
    void delete(int id);
}
