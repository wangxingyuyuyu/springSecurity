package com.example.security.config;

import com.example.security.entity.User;
import com.example.security.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/19
 * @Description:
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    @Resource
    private UserMapper userMapper;

    // 根据账号获取用户信息
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        // 查询数据库
        List<User> users = userMapper.queryUserByName(username);
        if (users.isEmpty()) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        User user = users.get(0);
        return new SecurityUser(user);
    }
}
