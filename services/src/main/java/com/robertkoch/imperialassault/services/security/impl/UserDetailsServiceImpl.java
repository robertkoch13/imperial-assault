package com.robertkoch.imperialassault.services.security.impl;

import com.robertkoch.imperialassault.services.models.LoginModel;
import com.robertkoch.imperialassault.services.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by robert.koch on 2017/02/15.
 */
@Service("customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    private LoginService loginService;

    @Autowired
    public UserDetailsServiceImpl(LoginService loginService) {
        this.loginService = loginService;
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LoginModel loginModel = loginService.findByUsername(username);
        if( loginModel != null) {
            try {
                return buildSpringUserFromAppUser(loginModel);
            } catch (NamingException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private UserDetails buildSpringUserFromAppUser(LoginModel loginModel) throws NamingException {
        String username = loginModel.getUsername();
        String password = loginModel.getPassword();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(loginModel.getRole().toString()));

        return new User(username, password, authorities);
    }

}
