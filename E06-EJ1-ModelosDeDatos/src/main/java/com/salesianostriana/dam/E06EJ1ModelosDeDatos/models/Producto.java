package com.salesianostriana.dam.E06EJ1ModelosDeDatos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Producto implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String nombre;

    private double pvp;

    @ManyToOne
    private Categoria categoria;

    /**
     * MÉTODOS AUXILIARES Ó HELPERS
     * ASOCIACION (Categoria/ Producto)
     */
    public void addCategoria(Categoria c) {
        this.categoria = c;
        if (c.getProductos() == null)
            c.setProductos(new ArrayList<>());
        c.getProductos().add(this);
    }

    public void removeCategoria(Categoria c) {
        c.getProductos().remove(this);
        this.categoria = null;
    }

}
