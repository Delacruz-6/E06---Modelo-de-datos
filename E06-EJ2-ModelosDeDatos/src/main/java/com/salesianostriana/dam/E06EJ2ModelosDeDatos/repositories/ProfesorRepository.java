package com.salesianostriana.dam.E06EJ2ModelosDeDatos.repositories;

import com.salesianostriana.dam.E06EJ2ModelosDeDatos.models.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor, Long> {
}