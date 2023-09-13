package com.finalBackEnd1.clinicaOdontologica.controller;

import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.service.OdontologoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping("/odontologos")
public class OdontologoController {

    @Autowired
    private OdontologoService odontologoService;

    @PostMapping
    public ResponseEntity<?> crearOdontologo (@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    @PutMapping
    public ResponseEntity<?> actualizarOdontologo (@RequestBody Odontologo odontologo){
        return ResponseEntity.ok(odontologoService.crearOdontologo(odontologo));
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> buscarOdontologoPorID (@PathVariable Long id){
        return ResponseEntity.ok(odontologoService.buscarOdontologoPorId(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarOdontologoPorID (@PathVariable Long id){
        odontologoService.borrarOdontologo(id);
        return  ResponseEntity.ok("Se borró correctamente el servicio con id " + id);

    }
}
