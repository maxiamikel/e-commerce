package com.maxi.ecommerce.services.detalleorden;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.ecommerce.models.DetalleOrden;
import com.maxi.ecommerce.repositories.DetalleOrdenRepository;

@Service
public class DetalleOrdenServiceImplementation implements DetalleOrdenService {

    @Autowired
    private DetalleOrdenRepository detalleOrdenRepository;

    @Override
    public DetalleOrden create(DetalleOrden detalleOrden) {
        return detalleOrdenRepository.save(detalleOrden);
    }

}
