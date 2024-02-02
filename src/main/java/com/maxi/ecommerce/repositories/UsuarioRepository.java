package com.maxi.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.ecommerce.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    public Usuario findByUsername(String username);
}
