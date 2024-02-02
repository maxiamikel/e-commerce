package com.maxi.ecommerce.services.orden;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Orden> findAll() {
        return ordenRepository.findAll();
    }

    public String generateOrdenNumber() {
        // Formato del numero: 0000000001
        int numberInt = 0;
        String numberFormated = "";

        List<Orden> ordens = ordenRepository.findAll();
        List<Integer> numbers = new ArrayList<Integer>();

        ordens.stream().forEach(x -> numbers.add(Integer.parseInt(x.getNumero())));
        if (ordens.isEmpty()) {
            numberInt = 1;
        } else {
            numberInt = numbers.stream().max(Integer::compare).get();
            numberInt += 1;
        }

        if (numberInt < 10) {
            numberFormated = "000000000" + String.valueOf(numberInt);
        } else if (numberInt < 100) {
            numberFormated = "00000000" + String.valueOf(numberInt);
        } else if (numberInt < 1000) {
            numberFormated = "0000000" + String.valueOf(numberInt);
        } else if (numberInt < 10000) {
            numberFormated = "000000" + String.valueOf(numberInt);
        } else if (numberInt < 100000) {
            numberFormated = "00000" + String.valueOf(numberInt);
        }
        return numberFormated;
    }

}
