package com.salesianostriana.dam.E06EJ1ModelosDeDatos.repositories;

import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Categoria;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Long> {
}