package com.maxi.ecommerce.services.orden;

import java.util.List;

import com.maxi.ecommerce.models.Orden;

public interface OrdenService {
    public Orden save(Orden orden);

    List<Orden> findAll();

    String generateOrdenNumber();
}
