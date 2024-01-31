package com.maxi.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxi.ecommerce.services.producto.ProductoServiceIMplementation;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoServiceIMplementation ProductoService;

    @GetMapping("/")
    public String home(Model model,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        model.addAttribute("productos", ProductoService.findAll(page));
        return "usuario/home";
    }

}
