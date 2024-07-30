package poointerface.repositorio.lista;

import poointerface.modelo.Producto;
import poointerface.repositorio.AbstracListRepositorio;
import poointerface.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ProductoListRepositorio extends AbstracListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) {
        Producto p = porId(producto.getId());
        if (p != null) {
            p.setDescripcion(producto.getDescripcion());
            p.setPrecio(producto.getPrecio());
        }

    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        List<Producto> lista = new ArrayList<>(this.dataSource);
        lista.sort((a, b) -> {
            int resultado = 0;
            if (dir == Direccion.ASC) {
                resultado = Ordenar(campo, a, b);
            } else if (dir == Direccion.DESC) {
                resultado = Ordenar(campo, b, a);
            }
            return resultado;
        });
        return lista;
    }

    public static int Ordenar(String campo, Producto a, Producto b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "descripcion" -> resultado = a.getDescripcion().compareTo(b.getDescripcion());
            case "precio" -> resultado = a.getPrecio().compareTo(b.getPrecio());
        }
        return resultado;
    }


}
