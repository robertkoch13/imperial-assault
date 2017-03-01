package com.robertkoch.imperialassault.web.controllers;

import com.robertkoch.imperialassault.services.security.LoginService;
import com.robertkoch.imperialassault.services.models.LoginModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class LoginController {

    private PasswordEncoder passwordEncoder;
    private LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService,
                           PasswordEncoder passwordEncoder) {
        this.loginService = loginService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping(value = "/login")
    public String loginPage() {
        return "login/login";
    }

    @GetMapping("/login/add")
    public String createLogin(Model model) {
        model.addAttribute("loginUser", loginService.getNewLoginModel());
        return "login/add";
    }

    @PostMapping("/login/add")
    public String createLoginPost(
            @ModelAttribute("loginUser") @Valid LoginModel loginModel) {

        loginService.createLogin(
                loginModel.getUsername(),
                passwordEncoder.encode(loginModel.getPassword()));

        return "redirect:/login";
    }

    @GetMapping(value = "/access_denied")
    public String accesssDenied() {
        return "login/access_denied";
    }

}
