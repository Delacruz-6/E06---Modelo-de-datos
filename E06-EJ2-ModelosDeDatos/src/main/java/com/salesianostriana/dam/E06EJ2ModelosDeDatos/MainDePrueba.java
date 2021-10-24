package com.salesianostriana.dam.E06EJ2ModelosDeDatos;

import com.salesianostriana.dam.E06EJ2ModelosDeDatos.models.CursoOnline;
import com.salesianostriana.dam.E06EJ2ModelosDeDatos.models.Profesor;
import com.salesianostriana.dam.E06EJ2ModelosDeDatos.models.Video;
import com.salesianostriana.dam.E06EJ2ModelosDeDatos.services.CursoOnlineService;
import com.salesianostriana.dam.E06EJ2ModelosDeDatos.services.ProfesorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final CursoOnlineService service;
    private final ProfesorService profesorService;

    @PostConstruct
    public void test() {


        Profesor profesor1 = Profesor.builder()
                .nombre("Luismi")
                .email("luismi.lopez@salesianos.edu")
                .puntuacion(10)
                .build();
        profesorService.save(profesor1);

        CursoOnline java = CursoOnline.builder()
                .nombre("Java desde 0")
                .puntuación(8.8)
                .profesor(profesor1)
                .build();
        java.addProfesor(profesor1);
        service.save(java);

        CursoOnline jpa = CursoOnline.builder()
                .nombre("Curso avanzado JPA")
                .puntuación(7.8)
                .profesor(profesor1)
                .build();
        jpa.addProfesor(profesor1);
        service.save(jpa);

        Video jpaV1 = Video.builder()
                .titulo("JPA ciclo de vida")
                .orden("3º parte")
                .descripcion("En esta parte del videotutorial hablaremos de los ciclos de vida de JPA")
                .url("www.salesianosTriana.com")
                .curso(java)
                .build();
        jpa.addVideo(jpaV1);

        Video jpaV2 = Video.builder()
                .titulo("Consultas con JPA")
                .orden("4º parte")
                .descripcion("En esta parte del videotutorial hablaremos de consultas que podemos utlizar con JPA")
                .url("www.salesianosTriana.com")
                .curso(jpa)
                .build();
        jpa.addVideo(jpaV2);


        System.out.printf("Nombre del curso y correo del profesor que lo imparte: ");
        System.out.printf("%s, %s\n", java.getNombre(), java.getProfesor().getEmail());
        System.out.printf("Nombre del profesor y numero de cursos y nombre - cantidad de videos curso jpa: ");
        System.out.printf("%s, %s, %s\n", profesor1.getNombre(), profesor1.getCursos().size(), profesor1.getCursos().get(1).getNombre() +" - "+ profesor1.getCursos().get(1).getVideoLists().size());
        System.out.printf("JPA Nombre del curso, cantidad de videos, titulo 1º video y descripcion 1º video:");
        System.out.printf("%s, %s, %s, %s\n", jpa.getVideoLists().get(1).getCurso().getNombre(), jpa.getVideoLists().size(), jpa.getVideoLists().get(1).getTitulo(), jpa.getVideoLists().get(1).getDescripcion());

        //Comprobacion borrado
        profesor1.removeCurso(jpa);
        java.removeProfesor(profesor1);
        System.out.printf("Nombre del profesor, numero de cursos, datos curso JPA de ese profesor: ");
        System.out.printf("%s, %s, %s \n", profesor1.getNombre(), profesor1.getCursos().size(), profesor1.getCursos());
        System.out.printf("Profesor del curso JAVA: ");
        System.out.printf("%s \n",java.getProfesor());
    }

}