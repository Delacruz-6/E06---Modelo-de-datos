package com.salesianostriana.dam.E06EJ2ModelosDeDatos.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
public class CursoOnline implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private double puntuación;

    @ManyToOne
    private Profesor profesor;

    @OneToMany(mappedBy="curso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Video> videoLists = new ArrayList<>();

    /**
     * MÉTODOS AUXILIARES Ó HELPERS
     * COMPOSICIÓN (CursoOnline / Video)
     */

    public void addVideo(Video v) {
        v.setCurso(this);
        if (v.getCurso().getVideoLists() == null)
            v.getCurso().setVideoLists(new ArrayList<>());
        this.videoLists.add(v);
    }

    public void removeVideo(Video c) {
        this.videoLists.remove(c);
        c.setCurso(null);
    }

    /**
     * MÉTODOS AUXILIARES Ó HELPERS
     * ASOCIACION (CursoOnline / Profesor)
     */
    public void addProfesor(Profesor p) {
        this.profesor = p;
        if (p.getCursos() == null)
            p.setCursos(new ArrayList<>());
        p.getCursos().add(this);
    }

    public void removeProfesor(Profesor p) {
        p.getCursos().remove(this);
        this.profesor = null;
    }

}
