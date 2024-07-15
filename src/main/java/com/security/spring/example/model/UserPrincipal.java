package com.security.spring.example.model;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.security.spring.example.entity.User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 
 * @author Kishore Hebbar
 *
 */
 
public class UserPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String userName;
    private String password;

    public UserPrincipal(String userName,String password,Collection<? extends GrantedAuthority> authorities){
        this.userName=userName;
        this.password=password;
        this.authorities=authorities;
    }

    private Collection<? extends GrantedAuthority> authorities;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

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

    @Override
    public boolean isEnabled() {
        return true;
    }
    public static UserPrincipal create(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return new UserPrincipal(user.getUsername(),user.getPassword(),authorities);
    }
}
