package com.salesianostriana.dam.E06EJ1ModelosDeDatos.services;

import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Producto;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.repositories.ProductoRepository;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.services.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class ProductoService
        extends BaseService<Producto, Long, ProductoRepository> {


}