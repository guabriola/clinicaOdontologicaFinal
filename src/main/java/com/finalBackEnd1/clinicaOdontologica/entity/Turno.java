package com.finalBackEnd1.clinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "turnos")
public class Turno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_paciente", nullable = false, referencedColumnName = "id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "id_odontologo", nullable = false, referencedColumnName = "id")
    private Odontologo odontologo;

    @Column(nullable = false)
    private LocalDate fechaYHora;

    public Turno(Paciente paciente, Odontologo odontologo, LocalDate fechaYHora) {
        this.paciente = paciente;
        this.odontologo = odontologo;
        this.fechaYHora = fechaYHora;
    }
}
