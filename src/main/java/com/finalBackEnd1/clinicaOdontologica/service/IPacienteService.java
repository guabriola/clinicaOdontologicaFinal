package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;

import java.util.Set;

public interface IPacienteService {
    PacienteDTO crearPaciente(Paciente paciente);
    PacienteDTO actualizarPaciente(Paciente paciente) throws ResourceNotFoundException;
    void borrarPaciente (Long id) throws ResourceNotFoundException;
    PacienteDTO buscarPacientePorId(Long id);
    Paciente devovlerPacienteCompleto(Long id);
    Set<PacienteDTO> listarPacientesDTO();
    Set<Paciente> listarPacientes();
}
