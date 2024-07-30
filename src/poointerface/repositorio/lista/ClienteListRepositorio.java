package poointerface.repositorio.lista;

import poointerface.modelo.Cliente;
import poointerface.repositorio.AbstracListRepositorio;
import poointerface.repositorio.Direccion;

import java.util.ArrayList;
import java.util.List;

public class ClienteListRepositorio extends AbstracListRepositorio<Cliente> {


    @Override
    public void editar(Cliente cliente) {
        Cliente c = porId(cliente.getId());
        if (c != null) {
            c.setNombre(cliente.getNombre());
            c.setApellido(cliente.getApellido());
        }

    }

    @Override
    public List listar(String campo, Direccion dir) {
        List<Cliente> lista = new ArrayList<>(this.dataSource);
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

    public static int Ordenar(String campo, Cliente a, Cliente b) {
        int resultado = 0;
        switch (campo) {
            case "id" -> resultado = a.getId().compareTo(b.getId());
            case "nombre" -> resultado = a.getNombre().compareTo(b.getNombre());
            case "apellido" -> resultado = a.getApellido().compareTo(b.getApellido());
        }
        return resultado;
    }
}
