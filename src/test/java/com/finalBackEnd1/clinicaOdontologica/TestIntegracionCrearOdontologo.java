package com.finalBackEnd1.clinicaOdontologica;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.finalBackEnd1.clinicaOdontologica.entity.Odontologo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false) //Desactivo la seguridad
public class TestIntegracionCrearOdontologo {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void registrarOdontologoTest() throws Exception {
        // Datos de ejemplo para el nuevo odontólogo
        String nombre = "Juan";
        String apellido = "Perez";
        String matricula = "12345";

        // Construir el JSON con los datos del odontólogo
        String jsonBody = "{"
                + "\"nombre\": \"" + nombre + "\","
                + "\"apellido\": \"" + apellido + "\","
                + "\"matricula\": \"" + matricula + "\""
                + "}";

        // Realizar la solicitud POST para registrar el odontólogo
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders
                        .post("/odontologos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonBody))
                .andExpect(MockMvcResultMatchers.status().isOk()) // Verificar que el código de respuesta es 200
                .andReturn();

        // Obtener la respuesta en formato JSON
        String responseJson = result.getResponse().getContentAsString();

        // Analizar la respuesta JSON para verificar que contiene el odontólogo registrado

        ObjectMapper objectMapper = new ObjectMapper();
        Odontologo odontologoRegistrado = objectMapper.readValue(responseJson, Odontologo.class);

        // Verificar que los datos del odontólogo coinciden con los proporcionados
        assertEquals(nombre, odontologoRegistrado.getNombre());
        assertEquals(apellido, odontologoRegistrado.getApellido());
        assertEquals(matricula, odontologoRegistrado.getMatricula());
    }
}
