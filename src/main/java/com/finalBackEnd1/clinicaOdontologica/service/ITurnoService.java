package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;

import java.util.Set;

public interface ITurnoService {

    TurnoDTO crearTurno (Turno turno);
    TurnoDTO actualizarTurno (Turno turno);
    void borrarTurno (Long id);
    TurnoDTO buscarTurnoPorId (Long id);

    Set<TurnoDTO> listarTurnos();

}