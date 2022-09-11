package com.it.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * UsersDetails实现类
 */
@Data
@NoArgsConstructor
public class LoginUser implements UserDetails {
    /**
     * 用户
     */
    private User user;
    /**
      返回权限集合
     */
    private List<String>permission;

    public LoginUser(User user, List<String> permission) {
        this.user = user;
        this.permission = permission;
    }

    /**
     *
     * @return 权限
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        //把permission中的string类型权限封装成SimpleGrantedAuthority
        List<GrantedAuthority>list=new ArrayList<>();
        for(String s:permission){
            SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(s);
            list.add(simpleGrantedAuthority);
        }
        return list;
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUserName();
    }
    /**
     *
     * @return 是否没过期
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }


    /**
     *
     * @return是否可用
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
