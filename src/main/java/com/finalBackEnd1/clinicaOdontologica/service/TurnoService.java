package com.finalBackEnd1.clinicaOdontologica.service;

import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
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

    @Autowired
    public TurnoService(TurnoRepository turnoRepository) {
        this.turnoRepository = turnoRepository;
    }

    @Override
    public TurnoDTO crearTurno(Turno turno) {
        return turnoATurnoDTO(turnoRepository.save(turno));
    }

    @Override
    public TurnoDTO actualizarTurno(Turno turno) {
        return turnoATurnoDTO(turnoRepository.save(turno));
    }

    @Override
    public void borrarTurno(Long id) {turnoRepository.deleteById(id); }

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
}
