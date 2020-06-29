package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.FacturaRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Factura;
import ar.org.centro8.curso.java.aplicaciones.enumerados.Letra;

public class TestFacturaRepository {
    public static void main(String[] args) {
        I_FacturaRepository fr=new FacturaRepository("http://localhost:8081/Server/facturas/v1/");
        System.out.println("Inicio del TestFacturaRepository");
        System.out.println("\n****************************\n");
        
        System.out.println("Cargo las facturas 'A100','B100' y 'C100' con el método 'save'");
        Factura factura=new Factura(Letra.A, 103, "12-01-2017", 214.80, 1);
        fr.save(factura);
        Factura factura2 = new Factura(Letra.B, 1002, "22-06-2018", 255.40, 2);
        fr.save(factura2);
        Factura factura3 = new Factura(Letra.C, 1002, "05-12-2018", 122, 2);
        fr.save(factura3);
        System.out.println(factura+"\n"+factura2+"\n"+factura3);
        System.out.println("\n****************************\n");
        
        System.out.println("Recorro la lista con un foreach del método 'getAll'");
        fr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de id:3 con el método 'getById'");
        System.out.println(fr.getById(3));
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros de idCliente:1 con el método 'getByIdCliente'");
        fr.getByIdCliente(1).forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de la factura 'A1' con el método 'getByLetraNumero'");
        System.out.println(fr.getByLetraNumero(Letra.A, 1));
        System.out.println("\n****************************\n");
        
        System.out.println("Elimino el registro de id:3 con el método 'remove'");
        fr.remove(fr.getById(3));
        fr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Fin del TestFacturaRepository");
    }
}
