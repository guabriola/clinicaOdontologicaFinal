package com.finalBackEnd1.clinicaOdontologica.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "domicilios")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String calle;
    @Column(nullable = false)
    private String numero;
    @Column(nullable = false)
    private String provincia;
    @Column(nullable = false)
    private String ciudad;

    public Domicilio(String calle, String numero, String provincia, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.provincia = provincia;
        this.ciudad = ciudad;
    }
}
