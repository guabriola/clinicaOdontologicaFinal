package com.finalBackEnd1.clinicaOdontologica.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.repository.OdontologoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;

    @Autowired
    ObjectMapper mapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository) {
        this.odontologoRepository = odontologoRepository;
    }

    @Override
    public OdontologoDTO crearOdontologo(Odontologo odontologo) {
        return mapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);
    }

    @Override
    public OdontologoDTO actualizarOdontologo(Odontologo odontologo) {
        return mapper.convertValue(odontologoRepository.save(odontologo), OdontologoDTO.class);
    }



    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) {
        Optional<Odontologo> odontologoBuscado = odontologoRepository.findById(id);
        OdontologoDTO odontologoDTOEncontrado = null;
        if(odontologoBuscado.isPresent()){
            odontologoDTOEncontrado = mapper.convertValue(odontologoBuscado, OdontologoDTO.class);
        }
        return odontologoDTOEncontrado;
    }

    @Override
    public void borrarOdontologo(Long id) {
        odontologoRepository.deleteById(id);
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        List<Odontologo> listaOdontologos = odontologoRepository.findAll();
        Set<OdontologoDTO> listaEncontradosDTO = new HashSet<>();
        for (Odontologo odontologo:listaOdontologos) {
            listaEncontradosDTO.add(mapper.convertValue(odontologo, OdontologoDTO.class));
        }
        return listaEncontradosDTO;
    }
}
