package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.repository.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DomicilioService implements IDomicilioService{

    @Autowired
    private DomicilioRepository domicilioRepository;


    @Override
    public void crearDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public void actualizarDomicilio(Domicilio domicilio) {
        domicilioRepository.save(domicilio);
    }

    @Override
    public void borrarDomicilio(Long id) {
        domicilioRepository.deleteById(id);
    }

    @Override
    public Domicilio buscarDomicilioPorId(Long id) {
        Optional<Domicilio> domicilioBuscado = domicilioRepository.findById(id);
        Domicilio domicilioEncontrado = null;
        if(domicilioBuscado.isPresent()) {
            domicilioEncontrado = domicilioBuscado.get();
        }
        return domicilioEncontrado;
    }
}
