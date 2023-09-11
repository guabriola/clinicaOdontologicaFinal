package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;

import java.util.Set;

public interface IOdontologoService {
    OdontologoDTO crearOdontologo(Odontologo odontologo);
    OdontologoDTO actualizarOdontologo(Odontologo odontologo);
    void borrarOdontologo(Long id);
    OdontologoDTO buscarOdontologoPorId(Long id);
    Set<OdontologoDTO> listarOdontologos();
}
