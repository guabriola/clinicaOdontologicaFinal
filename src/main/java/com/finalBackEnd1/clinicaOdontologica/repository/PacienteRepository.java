package com.finalBackEnd1.clinicaOdontologica.repository;


import com.finalBackEnd1.clinicaOdontologica.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository extends JpaRepository <Paciente, Long>{
}
