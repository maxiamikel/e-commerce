package com.maxi.ecommerce.services.orden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.ecommerce.models.Orden;
import com.maxi.ecommerce.repositories.OrdenRepository;

@Service
public class OrdenServiceImplementation implements OrdenService {

    @Autowired
    private OrdenRepository ordenRepository;

    @Override
    public Orden save(Orden orden) {
        return ordenRepository.save(orden);
    }

}
