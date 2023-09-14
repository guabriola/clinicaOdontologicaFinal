package com.finalBackEnd1.clinicaOdontologica.controller;

import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import com.finalBackEnd1.clinicaOdontologica.service.ITurnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/turnos")
public class TurnoController {

    @Autowired
    ITurnoService turnoService;

    @PostMapping
    public ResponseEntity<TurnoDTO> crearTurno(@RequestBody Turno turno){
        return ResponseEntity.ok(turnoService.crearTurno(turno));
    }

    @PutMapping
    public ResponseEntity<TurnoDTO> actualizarTurno(@RequestBody Turno turno) {
        return ResponseEntity.ok(turnoService.crearTurno(turno));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TurnoDTO> buscarTurnoPOrID(@PathVariable Long id){
        return ResponseEntity.ok(turnoService.buscarTurnoPorId(id));
    }

    @DeleteMapping
    public ResponseEntity<String> borrarTurnoPorId(@PathVariable Long id){
        turnoService.borrarTurno(id);
        return ResponseEntity.ok("Se borró correctamente el usuario con id número " + id + ".");
    }

}
