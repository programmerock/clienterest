package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.ArticuloRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Articulo;

public class TestArticuloRepository {
    public static void main(String[] args) {
        I_ArticuloRepository ar= new ArticuloRepository("http://localhost:8081/Server/articulos/v1/");
        System.out.println("Inicio del TestArticuloRepository\n");
        System.out.println("****************************\n");
        
        System.out.println("Ingreso 3 artículos 'remera blanca, camisa celeste "
                + "y pantalón negro' con el método save");
        Articulo articulo= new Articulo("Remera_blanca", 70, 100, 200, 50, 500);
        ar.save(articulo);
        Articulo articulo2=new Articulo("Camisa_celeste", 130, 200, 200, 50, 500);
        ar.save(articulo2);
        Articulo articulo3=new Articulo("Pantalón_negro", 400, 200, 200, 50, 500);
        ar.save(articulo3);
        System.out.println(articulo+"\n"+articulo2+"\n"+articulo3);
        System.out.println("\n****************************\n");
        
        System.out.println("Recorro la lista de artículos con un foreach del método 'getAll'");
        ar.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        
        System.out.println("Busco el registro de id:7 con el método 'getById'");
        System.out.println(ar.getById(7));
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros que contengan la palabra 'negro' con el método 'getLike'");
        ar.getLikeDescripcion("negro").forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros que tengan en sotck 200 unidades con el método 'getByStock'");
        ar.getByStock(200).forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Elimino el registro de id:8 con el método 'remove'");
        ar.remove(ar.getById(8));
        ar.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Fin del TestArticuloRepository");
    }
}
