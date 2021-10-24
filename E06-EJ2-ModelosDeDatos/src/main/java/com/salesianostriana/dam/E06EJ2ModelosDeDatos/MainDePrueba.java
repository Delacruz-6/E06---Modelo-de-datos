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

        CursoOnline dam2 = CursoOnline.builder()
                .nombre("2º DAM")
                .puntuación(7.8)
                .profesor(profesor1)
                .build();
        //profesor1.getCursos().add(dam2);
        dam2.addProfesor(profesor1);
        service.save(dam2);

        Video dam2V1 = Video.builder()
                .titulo("JPA ciclo de vida")
                .orden("3º parte")
                .descripcion("En esta parte del videotutorial hablaremos de los ciclos de vida de JPA")
                .url("www.salesianosTriana.com")
                .curso(dam2)
                .build();
        dam2.addVideo(dam2V1);

        Video dam2V2 = Video.builder()
                .titulo("Consultas con JPA")
                .orden("4º parte")
                .descripcion("En esta parte del videotutorial hablaremos de consultas que podemos utlizar con JPA")
                .url("www.salesianosTriana.com")
                .curso(dam2)
                .build();
        dam2.addVideo(dam2V2);


        System.out.printf("Nombre del curso, del profesor:");
        System.out.printf("%s, %s\n", dam2.getNombre(), dam2.getProfesor().getNombre());
        System.out.printf("Nombre del profesor y numero de cursos y cantidad de videos:");
        System.out.printf("%s, %s, %s\n", profesor1.getNombre(), profesor1.getCursos().size(), dam2.getVideoLists().size());
        System.out.println("Video:");
        System.out.printf("%s, %s\n", dam2V1.getTitulo(), dam2V1.getDescripcion(),dam2V1.getCurso());










    }

}