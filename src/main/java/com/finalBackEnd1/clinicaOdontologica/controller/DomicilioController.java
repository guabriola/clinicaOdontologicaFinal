package com.finalBackEnd1.clinicaOdontologica.controller;

import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.finalBackEnd1.clinicaOdontologica.repository.DomicilioRepository;
import com.finalBackEnd1.clinicaOdontologica.service.IDomicilioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/domicilios")
public class DomicilioController {

    @Autowired
    IDomicilioService domicilioService;

    @PostMapping
    public void crearDomicilio(@RequestBody Domicilio domicilio) throws Exception{
        domicilioService.crearDomicilio(domicilio);
    }

    @PutMapping
    public void actualizarDomicilio(@RequestBody Domicilio domicilio) throws ResourceNotFoundException {
        domicilioService.actualizarDomicilio(domicilio);
    }

    @DeleteMapping("/{id}")
    public void borrarDomicilio(@PathVariable Long id) throws ResourceNotFoundException{
        domicilioService.borrarDomicilio(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Domicilio> buscarDomicilio(@PathVariable Long id){
        Domicilio domicilioBuscado = domicilioService.buscarDomicilioPorId(id);
        return ResponseEntity.ok(domicilioBuscado);
    }
}
