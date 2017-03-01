package com.robertkoch.imperialassault.services.security.impl;

import com.robertkoch.imperialassault.domain.enums.Role;
import com.robertkoch.imperialassault.domain.login.Login;
import com.robertkoch.imperialassault.persistence.login.LoginRepository;
import com.robertkoch.imperialassault.services.models.LoginModel;
import com.robertkoch.imperialassault.services.security.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by robert.koch on 2017/02/16.
 */
@Service
public class LoginServiceImpl implements LoginService {
    private LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public LoginModel findByUsername(String username) {
        return new LoginModel(loginRepository.findByUsername(username));
    }

    @Override
    public LoginModel createLogin(String username, String password) {
        return createLogin(username, password, Role.Standard);
    }

    @Override
    @Transactional
    public LoginModel createLogin(String username, String password, Role role) {
        return new LoginModel(loginRepository.save(new Login(username, password, role)));
    }

    @Override
    public LoginModel createLogin(LoginModel loginModel) {
        return createLogin(loginModel.getUsername(), loginModel.getPassword(), loginModel.getRole());
    }

    @Override
    public LoginModel getNewLoginModel() {
        return new LoginModel();
    }
}
