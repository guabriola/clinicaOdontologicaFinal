package com.finalBackEnd1.clinicaOdontologica.repository;

import com.finalBackEnd1.clinicaOdontologica.entity.Turno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnoRepository extends JpaRepository <Turno, Long> {
}
