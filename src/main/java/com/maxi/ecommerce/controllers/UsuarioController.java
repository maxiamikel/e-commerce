package com.maxi.ecommerce.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxi.ecommerce.models.Usuario;
import com.maxi.ecommerce.services.usuario.UsuarioServiceImplementation;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioServiceImplementation usuarioService;

    @GetMapping("/signup")
    public String signup() {

        return "usuario/registro";
    }

    @GetMapping("/login")
    public String login() {

        return "usuario/login";
    }

    @PostMapping("/save")
    public String save(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
        // return "usuario/login";
    }

}
