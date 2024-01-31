package com.maxi.ecommerce.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxi.ecommerce.models.Producto;
import com.maxi.ecommerce.models.Usuario;
import com.maxi.ecommerce.services.producto.ProductoServiceIMplementation;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoServiceIMplementation productoService;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", productoService.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create() {
        return "/productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto) {
        Usuario usuario = new Usuario();
        usuario.setId(1);
        LOGGER.info("Nuevo producto {}", producto);
        producto.setUsuario(usuario);
        productoService.save(producto);
        return "redirect:/productos";
    }

}
