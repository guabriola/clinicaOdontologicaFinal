package com.finalBackEnd1.clinicaOdontologica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.time.LocalDate;


@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //Desactivo la seguridad
public class TestIntegracionCrearPaciente {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PacienteService pacienteService;


    @Test
    public void registrarNuevoPacienteTest() throws Exception {

        // Crea un paciente de ejemplo que se enviará en la solicitud
        Paciente paciente = new Paciente("Juan", "Pérez", "1234567890", LocalDate.of(1990, 5, 15), new Domicilio("Calle 123", "12345", "Ciudad", "Provincia"));

        // Convierte el paciente a JSON
        String pacienteJson = objectMapper.writeValueAsString(paciente);


        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(pacienteJson))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
