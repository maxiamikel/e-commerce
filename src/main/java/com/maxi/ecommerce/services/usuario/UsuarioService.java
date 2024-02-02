package com.maxi.ecommerce.services.usuario;

import java.util.Optional;

import com.maxi.ecommerce.models.Usuario;

public interface UsuarioService {

    public Optional<Usuario> findById(Integer id);

    // public Usuario findById(Integer id);
}
