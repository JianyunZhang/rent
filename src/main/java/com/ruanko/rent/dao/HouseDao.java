package com.ruanko.rent.dao;

import com.ruanko.rent.entity.House;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HouseDao {
    @Select("SELECT * FROM house")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "landlord", column = "landlord"),
            @Result(property = "name", column = "name"),
            @Result(property = "picture", column = "picture"),
            @Result(property = "location", column = "location"),
            @Result(property = "category", column = "category"),
            @Result(property = "area", column = "area"),
            @Result(property = "floor", column = "floor"),
            @Result(property = "price", column = "price"),
            @Result(property = "publishdate", column = "publishdate"),
            @Result(property = "ischeck", column = "ischeck"),
            @Result(property = "islease", column = "islease")
    })
    List<House> getAll();

    @Select("SELECT * FROM house WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "landlord", column = "landlord"),
            @Result(property = "name", column = "name"),
            @Result(property = "picture", column = "picture"),
            @Result(property = "location", column = "location"),
            @Result(property = "category", column = "category"),
            @Result(property = "area", column = "area"),
            @Result(property = "floor", column = "floor"),
            @Result(property = "price", column = "price"),
            @Result(property = "publishdate", column = "publishdate"),
            @Result(property = "ischeck", column = "ischeck"),
            @Result(property = "islease", column = "islease")
    })
    House getOne(int id);

    @Insert("INSERT INTO house(id, landlord, name, picture, location, category, area, floor, price, publishdate, ischeck, islease) VALUES(#{id}, #{landlord}, #{name}, #{picture}, #{location}, #{category}, #{area}, #{floor}, #{price}, #{publishdate}, #{ischeck}, #{islease})")
    void insert(House house);

    @Update("UPDATE house SET id=#{id}, landlord = #{landlord}, name = #{name}, picture = #{picture}, location = #{location}, category = #{category}, area = #{area}, floor = #{floor}, price = #{price}, publishdate = #{publishdate}, ischeck = #{ischeck}, islease = #{islease} WHERE id = #{id}")
    void update(House house);

    @Delete("DELETE FROM house WHERE id = #{id}")
    void delete(int id);
}
