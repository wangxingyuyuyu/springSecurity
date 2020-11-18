package com.example.security.mapper;

import com.example.security.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
}
