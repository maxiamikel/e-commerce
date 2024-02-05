package com.maxi.ecommerce.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.maxi.ecommerce.enums.TipoUsuario;
import com.maxi.ecommerce.models.Usuario;
import com.maxi.ecommerce.services.usuario.UsuarioServiceImplementation;

import jakarta.servlet.http.HttpSession;

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

    @PostMapping("/logar")
    public String logar(Usuario usuario, HttpSession session, Model model) {

        Optional<Usuario> usuarioDB = usuarioService.findByEmail(usuario.getEmail());
        if (usuarioDB.isPresent()) {
            session.setAttribute("userId", usuarioDB.get().getId());
            if (usuarioDB.get().getTipo().equals(TipoUsuario.ADMIN)) {
                return "redirect:/administrador";
            } else {
                return "redirect:/";
            }
        }

        model.addAttribute("usuario", usuarioService.findByEmail(usuario.getEmail()));
        return "redirect:/";
    }

    @PostMapping("/save")
    public String save(Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/";
        // return "usuario/login";
    }

}
