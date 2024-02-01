package com.maxi.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.ecommerce.models.DetalleOrden;

public interface DetalleOrdenRepository extends JpaRepository<DetalleOrden, Integer> {

}
