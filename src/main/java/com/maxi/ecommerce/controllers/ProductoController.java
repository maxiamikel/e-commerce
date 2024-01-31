package com.maxi.ecommerce.controllers;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String show(Model model,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "3") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        model.addAttribute("productos", productoService.findAll(page));
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

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = productoService.get(id);
        producto = optionalProducto.get();
        model.addAttribute("producto", producto);
        LOGGER.info("Producto encontrado {}", producto);

        return "/productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto) {
        productoService.update(producto);
        return "redirect:/productos";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        productoService.delete(id);
        return "redirect:/productos";
    }

}
