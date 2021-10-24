package com.salesianostriana.dam.E06EJ1ModelosDeDatos.models;

import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity @Builder
@NoArgsConstructor @AllArgsConstructor
@Getter @Setter
public class Categoria  implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private String nombre;

    @OneToMany(mappedBy="categoria")
    private List<Producto> productos;

    @Nullable
    @ManyToOne
    @JoinColumn(name = "padre_id")
    private Categoria padre;

    @Builder.Default
    @OneToMany(mappedBy = "padre", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Categoria> hija =  new ArrayList<>();



    /**
     * MÉTODOS AUXILIARES Ó HELPERS
     * ASOCIACION (CategoriaHija 0* / 1 CategoriaPadre)
     */
    public void addCategoriaHija(Categoria c) {
        this.hija.add(c);
        c.setPadre(this);
    }

    public void removeCategoriaHija(Categoria c) {
        this.hija.remove(c);
        c.setPadre(null);
    }


}
