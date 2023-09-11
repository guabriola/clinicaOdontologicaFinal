package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;

import java.util.Optional;
import java.util.Set;

public interface IPacienteService {
    PacienteDTO crearPaciente(Paciente paciente);
    PacienteDTO actualizarPaciente(Paciente paciente);
    void borrarPaciente (Long id);
    PacienteDTO buscarPacientePorId(Long id);
    Set<PacienteDTO> listarPacientes();
}
