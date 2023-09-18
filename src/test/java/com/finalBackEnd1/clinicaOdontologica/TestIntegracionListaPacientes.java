package com.finalBackEnd1.clinicaOdontologica;

import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.service.PacienteService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import java.time.LocalDate;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //Desactivo la seguridad
public class TestIntegracionListaPacientes {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private MockMvc mockMvc;

    public void cargaDatos(){
        Domicilio domicilio1 = new Domicilio("Calle1", "1234", "Provincia", "ciudad");
        Domicilio domicilio2 = new Domicilio("Calle2", "3654", "Provincia", "ciudad");
        Paciente paciente1 = pacienteService.pacienteDtoAPaciente(pacienteService.crearPaciente(
                new Paciente("Fernando", "Cadenazo", "12345", LocalDate.of(2023,8,3),domicilio1)));

        Paciente paciente2 = pacienteService.pacienteDtoAPaciente(pacienteService.crearPaciente(
                new Paciente("Ernesto", "Cadenazo", "12345", LocalDate.of(2022,8,2),domicilio2)));
    }

    @Test
    public void listarPacientesTest() throws Exception {
        cargaDatos();

        MvcResult resultado= mockMvc.perform(MockMvcRequestBuilders.get("/pacientes").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertFalse(resultado.getResponse().getContentAsString().isEmpty());

    }
}
