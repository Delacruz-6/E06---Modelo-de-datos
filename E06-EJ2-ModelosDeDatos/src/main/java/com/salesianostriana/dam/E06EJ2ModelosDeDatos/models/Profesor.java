package com.salesianostriana.dam.E06EJ2ModelosDeDatos.models;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter @Setter
@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    private String email;

    private double puntuacion;

    @OneToMany(mappedBy="profesor")
    private List<CursoOnline> cursos;

    /**
     * MÉTODOS AUXILIARES Ó HELPERS
     * ASOCIACION (CursoOnline / Profesor)
     */

    public void addCurso(CursoOnline c) {
        this.cursos.add(c);
        c.setProfesor(this);
    }

    public void removeCurso(CursoOnline c) {
        this.cursos.remove(c);
        c.setProfesor(null);
    }


}
