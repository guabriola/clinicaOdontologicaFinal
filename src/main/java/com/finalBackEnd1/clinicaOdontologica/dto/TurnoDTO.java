package com.finalBackEnd1.clinicaOdontologica.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TurnoDTO {
    private Long id;
    private Long pacienteId;
    private Long odontologoId;
    private LocalDate fechaYHora;
}
