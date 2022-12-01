package com.example.product.app.controllers.gui;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    /// Show UI
    @GetMapping(value = {"/", "/home"})
    public String accessHomePage() {
        return "home";
    }
}
