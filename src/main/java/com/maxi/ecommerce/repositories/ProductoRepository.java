package com.maxi.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.ecommerce.models.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer> {

}
