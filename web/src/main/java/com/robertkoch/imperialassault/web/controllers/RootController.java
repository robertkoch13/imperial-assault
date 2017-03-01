package com.robertkoch.imperialassault.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("")
    public String getSiteRoot() {
        return "redirect:/campaigns/list";
    }
}