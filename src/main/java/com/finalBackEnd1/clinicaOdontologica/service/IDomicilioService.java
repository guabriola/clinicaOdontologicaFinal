package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;

import java.util.Set;

public interface IDomicilioService {
    void crearDomicilio (Domicilio domicilio);
    void actualizarDomicilio (Domicilio domicilio);
    void borrarDomicilio (Long id);
    Domicilio buscarDomicilioPorId(Long id);

}
