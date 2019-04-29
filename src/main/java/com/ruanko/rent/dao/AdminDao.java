package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminDao {
    @Select("SELECT * FROM admin")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    List<Admin> getAll();

    @Select("SELECT * FROM admin WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    Admin getOne(String id);

    @Insert("INSERT INTO admin(id, password, name, phone, email, icon, registerdate) VALUES(#{id}, #{password}, #{name}, #{phone}, #{email}, #{icon}, #{registerdate})")
    void insert(Admin admin);

    @Update("UPDATE admin SET id=#{id}, password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, icon = #{icon}, registerdate = #{registerdate} WHERE id = #{id}")
    void update(Admin admin);

    @Delete("DELETE FROM admin WHERE id = #{id}")
    void delete(String id);
}
