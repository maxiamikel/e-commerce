package com.maxi.ecommerce.services.producto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Pageable;

import com.maxi.ecommerce.models.Producto;

public interface ProductoService {

    public Producto save(Producto producto);

    public List<Producto> findAll(Pageable page);

    public Optional<Producto> get(Integer id);

    public void update(Producto producto);

    public void delete(Integer id);

    public List<Producto> findByNombreLike(String nombre);
}
