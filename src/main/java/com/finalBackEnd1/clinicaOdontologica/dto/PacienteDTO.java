package com.finalBackEnd1.clinicaOdontologica.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteDTO {
    private Long id;
    private String nombre;
    private String apellido;
    private Long domicilioId;

}
