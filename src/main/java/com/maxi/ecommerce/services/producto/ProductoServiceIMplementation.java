package com.maxi.ecommerce.services.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maxi.ecommerce.models.Producto;
import com.maxi.ecommerce.repositories.ProductoRepository;

@Service
public class ProductoServiceIMplementation implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto save(Producto producto) {
        Producto newPeoducto = productoRepository.save(producto);
        return newPeoducto;
    }

    @Override
    public Optional<Producto> get(Integer id) {
        return productoRepository.findById(id);
    }

    @Override
    public void update(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void delete(Integer id) {
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> findAll(Pageable page) {
        return productoRepository.findAll(page).toList();
    }

    @Override
    public List<Producto> findByNombreLike(String nombre) {
        return productoRepository.findByNombreLikeParam(nombre);
    }

}
