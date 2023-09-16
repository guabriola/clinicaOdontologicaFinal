package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio (Domicilio domicilio) throws Exception;
    void actualizarDomicilio (Domicilio domicilio) throws ResourceNotFoundException;
    void borrarDomicilio (Long id) throws ResourceNotFoundException;
    Domicilio buscarDomicilioPorId(Long id);

}
