package com.ruanko.rent.dao;

import com.ruanko.rent.entity.Checklog;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChecklogDao {
    @Select("SELECT * FROM checklog")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "admin", column = "admin"),
            @Result(property = "house", column = "house"),
            @Result(property = "checkdate", column = "checkdate"),
            @Result(property = "checkresult", column = "checkresult")
    })
    List<Checklog> getAll();

    @Select("SELECT * FROM checklog WHERE id = #{id}")
    @Results({
            @Result(property = "id",  column = "id"),
            @Result(property = "admin", column = "admin"),
            @Result(property = "house", column = "house"),
            @Result(property = "checkdate", column = "checkdate"),
            @Result(property = "checkresult", column = "checkresult")
    })
    Checklog getOne(int id);

    @Insert("INSERT INTO checklog(id, admin, house, checkdate, checkresult) VALUES(#{id}, #{admin}, #{house}, #{checkdate}, #{checkresult})")
    void insert(Checklog checklog);

    @Update("UPDATE checklog SET id = #{id}, admin = #{admin}, house = #{house}, checkdate = #{checkdate}, checkresult = #{checkresult} WHERE id = #{id}")
    void update(Checklog checklog);

    @Delete("DELETE FROM checklog WHERE id = #{id}")
    void delete(int id);
}
