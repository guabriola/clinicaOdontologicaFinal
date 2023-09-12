package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.OdontologoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.repository.OdontologoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OdontologoService implements IOdontologoService{

    @Autowired
    OdontologoRepository odontologoRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public OdontologoService(OdontologoRepository odontologoRepository, ModelMapper modelMapper) {
        this.odontologoRepository = odontologoRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OdontologoDTO crearOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public OdontologoDTO actualizarOdontologo(Odontologo odontologo) {
        return null;
    }

    @Override
    public void borrarOdontologo(Long id) {

    }

    @Override
    public OdontologoDTO buscarOdontologoPorId(Long id) {
        return null;
    }

    @Override
    public Set<OdontologoDTO> listarOdontologos() {
        return null;
    }
}
