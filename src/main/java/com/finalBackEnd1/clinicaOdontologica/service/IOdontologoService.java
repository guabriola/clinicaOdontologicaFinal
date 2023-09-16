package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IOdontologoService {
    OdontologoDTO crearOdontologo(Odontologo odontologo) throws Exception;
    OdontologoDTO actualizarOdontologo(Odontologo odontologo) throws ResourceNotFoundException;
    void borrarOdontologo(Long id) throws ResourceNotFoundException;
    OdontologoDTO buscarOdontologoPorId(Long id);
    Set<OdontologoDTO> listarOdontologos();
}
