package com.finalBackEnd1.clinicaOdontologica.controller;

import com.fasterxml.classmate.members.ResolvedParameterizedMember;
import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.service.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    IPacienteService pacienteService;

    @PostMapping
    public ResponseEntity<PacienteDTO> crearPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.crearPaciente(paciente));
    }

    @PutMapping
    public ResponseEntity<PacienteDTO> actualizarPaciente(@RequestBody Paciente paciente){
        return ResponseEntity.ok(pacienteService.actualizarPaciente(paciente));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PacienteDTO> buscarPacientePorId(@PathVariable Long id){
        return ResponseEntity.ok(pacienteService.buscarPacientePorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> borrarPacientePorId(@PathVariable Long id){
        pacienteService.borrarPaciente(id);
        return ResponseEntity.ok("Se borró correctamente el usuario con id número " + id + ".");
    }

}