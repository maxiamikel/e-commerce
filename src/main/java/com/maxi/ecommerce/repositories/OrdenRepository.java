package com.maxi.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.ecommerce.models.Orden;

public interface OrdenRepository extends JpaRepository<Orden, Integer> {

}
