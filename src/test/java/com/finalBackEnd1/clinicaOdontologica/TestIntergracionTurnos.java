package com.finalBackEnd1.clinicaOdontologica;

import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import com.finalBackEnd1.clinicaOdontologica.service.OdontologoService;
import com.finalBackEnd1.clinicaOdontologica.service.PacienteService;
import com.finalBackEnd1.clinicaOdontologica.service.TurnoService;
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

import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //Desactivo la seguridad
public class TestIntergracionTurnos {

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private OdontologoService odontologoService;
    @Autowired
    private TurnoService turnoService;
    @Autowired
    private MockMvc mockMvc;

    public void cargarDatos(){

        Paciente paciente = pacienteService.pacienteDtoAPaciente(pacienteService.crearPaciente(
                new Paciente("Guillermo", "Abriola", "12345", LocalDate.of(2023,8,3),
                        new Domicilio("Calle1", "1234", "Provincia", "ciudad"))
        ));

        Odontologo odontologo = odontologoService.OdontologoDtoAOdontologo(
                odontologoService.crearOdontologo(
                        new Odontologo("Mario", "Perez", "Ma-1234")));

        Turno turno = turnoService.turnoDTOaTurno(turnoService.crearTurno(
                new Turno(paciente, odontologo, LocalDate.of(2015,3,8))));
    }

    @Test
    public void listarTurnosTest() throws Exception {
        cargarDatos();
        MvcResult resultado = mockMvc.perform(MockMvcRequestBuilders.get("/turnos").accept(MediaType.APPLICATION_JSON))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        assertFalse(resultado.getResponse().getContentAsString().isEmpty());
    }
}
