package com.maxi.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.ecommerce.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {
    @Query("SELECT p FROM Producto p")
    public List<Producto> getAll();

    @Query("SELECT p FROM Producto p WHERE p.nombre LIKE %:nombre%")
    public List<Producto> findByNombreLikeParam(@Param("nombre") String nombre);
}
