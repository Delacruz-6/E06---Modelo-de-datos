package com.salesianostriana.dam.E06EJ1ModelosDeDatos.repositories;

import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
