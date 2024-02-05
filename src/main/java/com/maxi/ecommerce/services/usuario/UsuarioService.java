package com.maxi.ecommerce.services.usuario;

import java.util.Optional;

import com.maxi.ecommerce.models.Usuario;

public interface UsuarioService {

    public Optional<Usuario> findById(Integer id);

    public Usuario save(Usuario usuario);

    Optional<Usuario> findByEmail(String email);

    // public Usuario findById(Integer id);
}
