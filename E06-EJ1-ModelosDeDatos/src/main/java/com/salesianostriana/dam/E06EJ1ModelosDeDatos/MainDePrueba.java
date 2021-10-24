package com.salesianostriana.dam.E06EJ1ModelosDeDatos;

import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Categoria;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.models.Producto;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.services.CategoriaService;
import com.salesianostriana.dam.E06EJ1ModelosDeDatos.services.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class MainDePrueba {

    private final ProductoService prodService;
    private final CategoriaService catService;

    @PostConstruct
    public void test() {


        Categoria cat1 = Categoria.builder()
                .nombre("Jamones")
                .build();
        catService.save(cat1);

        Categoria cat2 = Categoria.builder()
                .nombre("Chorizos")
                .build();
        catService.save(cat2);

        Categoria catPadre = Categoria.builder()
                .nombre("Embutidos")
                .build();
        catService.save(catPadre);

        catPadre.addCategoriaHija(cat1);
        catPadre.addCategoriaHija(cat2);


        catService.save(cat1);



        Producto producto1 = Producto.builder()
                .nombre("Jamón")
                .pvp(50.6)
                .categoria(cat1)
                .build();
        prodService.save(producto1);

        producto1.addCategoria(cat1);

        producto1.addCategoria(cat2);




        System.out.printf("Nombre de la categoria, su categoria padre y cantidad de productos: ");
        System.out.printf("%s, %s, %s\n", cat1.getNombre(), cat1.getPadre().getNombre(), cat1.getProductos().size());
        System.out.printf("Nombre del productor, categoria y precio: ");
        System.out.printf("%s, %s, %s\n", producto1.getNombre(), producto1.getCategoria().getNombre(), producto1.getPvp());
        System.out.printf("Categoria padre, cantidad categorias hijas: ");
        System.out.printf("%s, %s\n", catPadre.getNombre(), catPadre.getHija().size());

        //Comprobación de borrado categoria padre y producto
        catPadre.removeCategoriaHija(cat2);
        producto1.removeCategoria(cat2);
        System.out.printf("Nombre de la categoria, su categoria padre y cantidad de productos: ");
        System.out.printf("%s, %s, %s\n", cat2.getNombre(), cat2.getPadre(), cat2.getProductos().size());



    }

}