package com.finalBackEnd1.clinicaOdontologica.controller;

import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.finalBackEnd1.clinicaOdontologica.service.IOdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private IOdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo (@RequestBody Odontologo odontologo) throws Exception{
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    @PutMapping
    public ResponseEntity<OdontologoDTO> actualizarOdontologo (@RequestBody Odontologo odontologo) throws ResourceNotFoundException {
        return ResponseEntity.ok(odontologoService.actualizarOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOdontologoPorID (@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologoPorID (@PathVariable Long id) throws ResourceNotFoundException{
        odontologoService.borrarOdontologo(id);
        return  ResponseEntity.ok("Se borró correctamente el servicio con id " + id);
    }

    @GetMapping
    public ResponseEntity<Set<OdontologoDTO>> listarOdontologos(){
        return ResponseEntity.ok(odontologoService.listarOdontologos());
    }
}
