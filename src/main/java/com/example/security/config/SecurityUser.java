package com.example.security.config;

import com.example.security.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: wxy
 * @Date: 2020/11/19
 * @Description:
 */
public class SecurityUser implements UserDetails {

    private transient User currentUserInfo;

    public SecurityUser() {}

    public SecurityUser(User user) {
        if (user != null) {
            this.currentUserInfo = user;
        }
    }

    public User getCurrentUserInfo() {
        return currentUserInfo;
    }

    public void setCurrentUserInfo(User currentUserInfo) {
        this.currentUserInfo = currentUserInfo;
    }

    // 用户授权
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        SimpleGrantedAuthority admin = new SimpleGrantedAuthority("admin");
        authorities.add(admin);
        return authorities;
    }

    @Override
    public String getPassword() {
        return currentUserInfo.getPassword();
    }

    @Override
    public String getUsername() {
        return currentUserInfo.getUsername();
    }

    // 账户是否过期
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 账户是否锁定
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 凭证是否过期
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 是否已启用
    @Override
    public boolean isEnabled() {
        return true;
    }
}
