package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.repository.PacienteRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import org.modelmapper.ModelMapper;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class PacienteService implements IPacienteService{

    private final PacienteRepository pacienteRepository;
    private final ModelMapper modelMapper;
    private final IDomicilioService domicilioService;

    @Autowired
    public PacienteService(PacienteRepository pacienteRepository, ModelMapper modelMapper, IDomicilioService domicilioService) {
        this.pacienteRepository = pacienteRepository;
        this.modelMapper = modelMapper;
        //configureModelMapper();
        this.domicilioService = domicilioService;
    }

    //Metodos manuales

    @Override
    public PacienteDTO crearPaciente(Paciente paciente){
         return pacienteApacienteDTO(pacienteRepository.save(paciente));
    }

    @Override
    public PacienteDTO actualizarPaciente(Paciente paciente){
        return pacienteApacienteDTO(pacienteRepository.save(paciente));
    }

    @Override
    public void borrarPaciente (Long id){
        pacienteRepository.deleteById(id);
    }

    @Override
    public PacienteDTO buscarPacientePorId(Long id){
        Optional<Paciente> pacienteBuscado = pacienteRepository.findById(id);
        PacienteDTO pacienteDTOEncontrado = null;
        if(pacienteBuscado.isPresent()){
            pacienteDTOEncontrado = pacienteApacienteDTO(pacienteBuscado.get());
        }
        return pacienteDTOEncontrado;
    }

    @Override
    public Set<PacienteDTO> listarPacientes() {
        List<Paciente> listaPacientes = pacienteRepository.findAll();
        Set <PacienteDTO> setPacientesDTO = new HashSet<>();
        for (Paciente paciente:
             listaPacientes) {
            setPacientesDTO.add(pacienteApacienteDTO(paciente));
        }
        return setPacientesDTO;
    }


    //NUEVOS MAPPERS
    public PacienteDTO pacienteApacienteDTO(Paciente paciente) {
        // Utiliza DomicilioService para obtener el domicilio
        PacienteDTO pacienteDTO = modelMapper.map(paciente, PacienteDTO.class);
        pacienteDTO.setDomicilioId(paciente.getDomicilio().getId());
        return pacienteDTO;
    }

    public Paciente pacienteDtoAPaciente(PacienteDTO pacienteDTO) {
        Paciente paciente = modelMapper.map(pacienteDTO, Paciente.class);

        // Utiliza DomicilioService para obtener el domicilio
        Domicilio domicilio = domicilioService.buscarDomicilioPorId(pacienteDTO.getDomicilioId());
        paciente.setDomicilio(domicilio);

        return paciente;
    }















}
