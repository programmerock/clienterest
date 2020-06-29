package ar.org.centro8.curso.java.aplicaciones.test;

import ar.org.centro8.curso.java.aplicaciones.dao.interfaces.I_ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.dao.rest.cliente.ClienteRepository;
import ar.org.centro8.curso.java.aplicaciones.entities.Cliente;
import ar.org.centro8.curso.java.aplicaciones.enumerados.TipoDocumento;

public class TestClienteRepository {
    public static void main(String[] args) {
        I_ClienteRepository cr=new ClienteRepository ("http://localhost:8081/Server/clientes/v1/");
        System.out.println("Inicio del TestClienteRepository\n");
        System.out.println("****************************\n");
        
        System.out.println("Ingreso 2 clientes (Marcelo Ramirez y Carlos Paez)con el método 'save'");
        Cliente cliente=new Cliente("Mario", "Ramos", TipoDocumento.DNI, 39912822, "Brown_354", null);
        cr.save(cliente);
        Cliente cliente2= new Cliente("Claudio", "Parrili", TipoDocumento.DNI, 19949922, "Belgrano_165","cliente_corporativo");
        cr.save(cliente2);
        System.out.println(cliente+"\n"+cliente2);
        System.out.println("\n****************************\n");
        
        System.out.println("Recorro la lista de clientes con un forEach del método 'getAll'");
        cr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de id:2 con el método 'getById'");
        System.out.println(cr.getById(2));
        System.out.println("\n****************************\n");
                    
        System.out.println("Busco el registro con DNI 12345678 con el método 'getByTipoNumero'");
        System.out.println(cr.getByTipoNumero(TipoDocumento.DNI, 12345678));
        System.out.println("\n****************************\n");
        
        System.out.println("Busco los registros que contengan la letra 'z' en su apellido con el método 'getLikeApellido'");
        cr.getLikeApellido("z").forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Busco el registro de nombre y apellido 'Marcelo Ramirez' con el método 'getLikeApellidoNombre'");
        cr.getLikeApellidoNombre("Ramirez", "Marcelo").forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Elimino el registro de id:3 con el método 'remove'");
        cr.remove(cr.getById(13));
        System.out.println("Recorro la lista para ver que ya no figure:");
        cr.getAll().forEach(System.out::println);
        System.out.println("\n****************************\n");
        
        System.out.println("Fin del TestClienteRepository");        
}
}
