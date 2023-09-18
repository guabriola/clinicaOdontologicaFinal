package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface ITurnoService {

    TurnoDTO crearTurno (Turno turno);
    TurnoDTO actualizarTurno (Turno turno) throws ResourceNotFoundException;
    void borrarTurno (Long id) throws ResourceNotFoundException;
    TurnoDTO buscarTurnoPorId (Long id);

    Set<TurnoDTO> listarTurnos();

}