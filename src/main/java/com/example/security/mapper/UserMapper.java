package com.example.security.mapper;

import com.example.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/18
 * @Description:
 */
@Mapper
public interface UserMapper {

    @Select("select * from t_user")
    List<User> queryList();

    @Select("select * from t_user where username = #{username}")
    List<User> queryUserByName(@Param("username") String username);
}
