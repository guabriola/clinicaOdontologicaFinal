package com.finalBackEnd1.clinicaOdontologica.modelMapper;

import com.finalBackEnd1.clinicaOdontologica.dto.PacienteDTO;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
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

        return modelMapper;
    }
}
