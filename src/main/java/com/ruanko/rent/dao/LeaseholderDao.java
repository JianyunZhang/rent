package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Leaseholder;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseholderDao {
    @Select("SELECT * FROM leaseholder")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    List<Leaseholder> getAll();

    @Select("SELECT * FROM leaseholder WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "password", column = "password"),
            @Result(property = "name", column = "name"),
            @Result(property = "phone", column = "phone"),
            @Result(property = "email", column = "email"),
            @Result(property = "icon", column = "icon"),
            @Result(property = "registerdate", column = "registerdate")
    })
    Leaseholder getOne(String id);

    @Insert("INSERT INTO leaseholder(id, password, name, phone, email, icon, registerdate) VALUES(#{id}, #{password}, #{name}, #{phone}, #{email}, #{icon}, #{registerdate})")
    void insert(Leaseholder leaseholder);

    @Update("UPDATE leaseholder SET id=#{id},password = #{password}, name = #{name}, phone = #{phone}, email = #{email}, icon = #{icon}, registerdate = #{registerdate} WHERE id = #{id}")
    void update(Leaseholder leaseholder);

    @Delete("DELETE FROM leaseholder WHERE id = #{id}")
    void delete(String id);
}
