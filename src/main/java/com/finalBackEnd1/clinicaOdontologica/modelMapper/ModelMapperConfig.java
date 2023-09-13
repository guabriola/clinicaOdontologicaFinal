package com.finalBackEnd1.clinicaOdontologica.modelMapper;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.dto.TurnoDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ModelMapperConfig {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        // Mapeo de Paciente a PacienteDTO
        modelMapper.createTypeMap(Paciente.class, PacienteDTO.class)
                .addMapping(src -> src.getDomicilio().getId(), PacienteDTO::setDomicilioId);

        // Mapeo de PacienteDTO a Paciente
        modelMapper.createTypeMap(PacienteDTO.class, Paciente.class)
                .addMapping(PacienteDTO::getDomicilioId, (dest, value) -> dest.getDomicilio().setId((Long) value));

        //Mapeo de Turno a TurnoDTO
        modelMapper.createTypeMap(Turno.class, TurnoDTO.class)
                .addMapping(src -> src.getOdontologo().getId(), TurnoDTO::setOdontologoId)
                .addMapping(src -> src.getPaciente().getId(), TurnoDTO::setPacienteId);
        //Mapeo de TurnoDTO a Turno
        modelMapper.createTypeMap(TurnoDTO.class, Turno.class)
                .addMapping(TurnoDTO::getOdontologoId, (dest, value) -> dest.getOdontologo().setId((Long) value))
                .addMapping(TurnoDTO::getPacienteId, (dest, value) -> dest.getPaciente().setId((Long) value));

        return modelMapper;
    }
}
