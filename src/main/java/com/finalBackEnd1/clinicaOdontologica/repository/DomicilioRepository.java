package com.finalBackEnd1.clinicaOdontologica.repository;

import com.finalBackEnd1.clinicaOdontologica.entity.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio, Long> {
}
