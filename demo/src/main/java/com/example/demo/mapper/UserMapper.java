package com.example.demo.mapper;


import com.example.demo.pojo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface UserMapper {
    @Select("SELECT 'Connection Successful'")
    String testConnection() ;

    @Select("select username from user where id=#{id}")
    User getUsernameById(String id);

    @Select("select * from user where username=#{username}")
    User getUserByUsername(String username);

    @Insert("INSERT INTO user(id, username,password) VALUES(#{user.id}, #{user.username},#{user.password})")
    void insert(@Param("user") User user);

    @Select("SELECT EXISTS(SELECT 1 FROM user WHERE username = #{username})")
    boolean existsByUsername(String username);

    @Select("select exists(select 1 from user where username=#{username} and password=#{password})")
    boolean existsByUsernameAndPassword(String username, String password);

}
