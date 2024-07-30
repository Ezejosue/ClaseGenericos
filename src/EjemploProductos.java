import poointerface.modelo.Producto;
import poointerface.repositorio.Direccion;
import poointerface.repositorio.OrdenablePaginaCrudRepository;
import poointerface.repositorio.lista.ProductoListRepositorio;

import java.util.List;

public class EjemploProductos {
    public static void main(String[] args) {
        OrdenablePaginaCrudRepository<Producto> repo = new ProductoListRepositorio();
        repo.crear(new Producto("mesa", 50.5));
        repo.crear(new Producto("silla", 20.5));
        repo.crear(new Producto("lampara", 15.5));
        repo.crear(new Producto("notebook", 500.5));

        List<Producto> productos = repo.listar();
        productos.forEach(System.out::println);
        System.out.println("==== paginable ====");
        List<Producto> paginable = repo.listar(1, 4);
        paginable.forEach(System.out::println);

        System.out.println("==== ordenar ====");
        List<Producto> productosOrdenAsc = repo.listar("descripcion", Direccion.ASC);
        for (Producto p : productosOrdenAsc) {
            System.out.println(p);
        }

        System.out.println("==== editar ====");
        Producto mesaActualizar = new Producto("mesa", 70.5);
        mesaActualizar.setId(1);
        repo.editar(mesaActualizar);
        Producto mesa = repo.porId(1);
        System.out.println(mesa);
        System.out.println("================");
        repo.listar("precio", Direccion.ASC).forEach(System.out::println);
        System.out.println("================");
        repo.eliminar(2);
        repo.listar().forEach(System.out::println);
        System.out.println("=== total ===");
        System.out.println("Total: " + repo.total());
    }
}
