import poointerface.modelo.Cliente;
import poointerface.repositorio.Direccion;
import poointerface.repositorio.OrdenablePaginaCrudRepository;
import poointerface.repositorio.lista.ClienteListRepositorio;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        OrdenablePaginaCrudRepository<Cliente> repository = new ClienteListRepositorio();
        repository.crear(new Cliente("Jano", "Perez"));
        repository.crear(new Cliente("Bea", "Gonzalez"));
        repository.crear(new Cliente("Luci", "Martinez"));
        repository.crear(new Cliente("Andres", "Guzman"));

        List<Cliente> clientes = repository.listar();
        clientes.forEach(System.out::println);
        System.out.println("==== paginable ====");
        List<Cliente> paginable = repository.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("==== ordenar ====");
        List<Cliente> clientesOrdenAsc = repository.listar("apellido", Direccion.ASC);
        for (Cliente c : clientesOrdenAsc) {
            System.out.println(c);
        }

        System.out.println("==== editar ====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repository.editar(beaActualizar);
        Cliente bea = repository.porId(2);
        System.out.println(bea);
        System.out.println("================");
        repository.listar("nombre", Direccion.ASC).forEach(System.out::println);
        System.out.println("================");
        repository.eliminar(2);
        repository.listar().forEach(System.out::println);
        System.out.println("=== total ===");
        System.out.println("Total: " + repository.total());
    }

}