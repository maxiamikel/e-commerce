package com.maxi.ecommerce.controllers;

import java.util.Optional;

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
import com.maxi.ecommerce.services.producto.ProductoServiceIMplementation;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductoServiceIMplementation productoService;

    // List<Producto> productos = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model,
            @RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
            @RequestParam(name = "pageSize", required = false, defaultValue = "8") int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        model.addAttribute("productos", productoService.findAll(page));
        return "usuario/home";
    }

    @GetMapping("/detalle/{id}")
    public String detalleProducto(@PathVariable Integer id, Model model) {
        Producto producto = new Producto();
        Optional<Producto> productoDB = productoService.get(id);
        producto = productoDB.get();
        model.addAttribute("producto", producto);
        return "usuario/detalle_producto";
    }

    @PostMapping("/cart")
    public String addToCart() {

        return "usuario/carrito";
    }

}
