package com.robertkoch.imperialassault.services.security;

import com.robertkoch.imperialassault.domain.enums.Role;
import com.robertkoch.imperialassault.services.models.LoginModel;

/**
 * Created by robert.koch on 2017/02/16.
 */
public interface LoginService {
    LoginModel findByUsername(String username);
    LoginModel createLogin(String username, String password);
    LoginModel createLogin(String username, String password, Role role);
    LoginModel createLogin(LoginModel loginModel);
    LoginModel getNewLoginModel();
}
