package com.salesianostriana.dam.E06EJ2ModelosDeDatos.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity @Builder
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private String orden;

    private String titulo;

    private String descripcion;

    private String url;

    @ManyToOne
    private CursoOnline curso;

}
