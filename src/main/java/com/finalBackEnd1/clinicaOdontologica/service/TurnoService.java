package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import com.finalBackEnd1.clinicaOdontologica.exceptions.ResourceNotFoundException;
import com.finalBackEnd1.clinicaOdontologica.repository.TurnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TurnoService implements ITurnoService{

    private final TurnoRepository turnoRepository;
    private final PacienteService pacienteService;
    private final OdontologoService odontologoService;

    @Autowired
    public TurnoService(TurnoRepository turnoRepository, PacienteService pacienteService, OdontologoService odontologoService) {
        this.turnoRepository = turnoRepository;
        this.pacienteService = pacienteService;
        this.odontologoService = odontologoService;
    }


    @Override
    public TurnoDTO crearTurno(Turno turno){
        return turnoATurnoDTO(turnoRepository.save(turno));
    }

    @Override
    public TurnoDTO actualizarTurno(Turno turno) throws ResourceNotFoundException {
        if(buscarTurnoPorId(turno.getId()) == null)
            throw new ResourceNotFoundException("El turno de Id: " + turno.getId() + " no existe en la base de datos.");
        return turnoATurnoDTO(turnoRepository.save(turno));
    }

    @Override
    public void borrarTurno(Long id) throws ResourceNotFoundException {
        if(buscarTurnoPorId(id) == null)
            throw new ResourceNotFoundException("El turno de Id: " + id + " no existe en la base de datos.");
        turnoRepository.deleteById(id);
    }

    @Override
    public TurnoDTO buscarTurnoPorId(Long id) {
        Optional<Turno> turnoBuscado = turnoRepository.findById(id);
        TurnoDTO turnoDTOEncontrado = null;
        if(turnoBuscado.isPresent()){
            turnoDTOEncontrado = turnoATurnoDTO(turnoBuscado.get());
        }
        return turnoDTOEncontrado;
    }

    @Override
    public Set<TurnoDTO> listarTurnos() {
        List<Turno> listaTurnos = turnoRepository.findAll();
        Set<TurnoDTO> setTurnosDTO = new HashSet<>();
        for (Turno turno:
             listaTurnos) {
            setTurnosDTO.add(turnoATurnoDTO(turno));
        }
        return setTurnosDTO;
    }

    private TurnoDTO turnoATurnoDTO(Turno turno){
        TurnoDTO turnoDTO = new TurnoDTO();
        turnoDTO.setId(turno.getId());
        turnoDTO.setPacienteId(turno.getPaciente().getId());
        turnoDTO.setOdontologoId(turno.getOdontologo().getId());
        turnoDTO.setFechaYHora(turno.getFechaYHora());
        return turnoDTO;
    }

    public Turno turnoDTOaTurno(TurnoDTO turnoDTO){
        Turno turno = new Turno();
        turno.setId(turnoDTO.getId());
        turno.setPaciente(pacienteService.pacienteDtoAPaciente(
                pacienteService.buscarPacientePorId(turnoDTO.getId())));
        turno.setOdontologo(odontologoService.OdontologoDtoAOdontologo(
                odontologoService.buscarOdontologoPorId(turnoDTO.getId())));
        turno.setFechaYHora(turnoDTO.getFechaYHora());
        return turno;
    }
}
