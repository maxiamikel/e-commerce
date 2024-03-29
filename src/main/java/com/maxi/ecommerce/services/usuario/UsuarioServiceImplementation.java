package com.maxi.ecommerce.services.usuario;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.ecommerce.enums.TipoUsuario;
import com.maxi.ecommerce.models.Usuario;
import com.maxi.ecommerce.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImplementation implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public Optional<Usuario> findById(Integer id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setTipo(TipoUsuario.USER);
        usuarioRepository.save(usuario);
        return usuario;
    }

    @Override
    public Optional<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

}
