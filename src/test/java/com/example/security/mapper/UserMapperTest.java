package com.example.security.mapper;

import com.example.security.BaseTest;
import com.example.security.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/18
 * @Description:
 */

class UserMapperTest extends BaseTest {

    @Resource
    private UserMapper userMapper;

    @Test
    void queryList() {
        // aql: SqlSessionFactory configuration -> mapperStatement -> sqlSource
        List<User> users = userMapper.queryList();
        for (User user : users) {
            System.out.println(user.getUsername());
        }
    }
}