package org.generic.generic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EjemploGenericos {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Josue", "Avalos"));

        Cliente josue = clientes.iterator().next();

        Cliente[] clientesArreglo = {new Cliente ("Andres", "Guzman"), new Cliente("Pepe", "Gomez")};

        Integer[] enterosArreglo = {1, 2, 3};

        List<Cliente> clientesLista = fromArrayToList(clientesArreglo);
        List<Integer> enterosLista = fromArrayToList(enterosArreglo);

        clientesLista.forEach(System.out::println);
        enterosLista.forEach(System.out::println);

        List<String> nombres = fromArrayToList(new String[]{"Josue", "Andres", "Pepe"}, enterosArreglo);

        nombres.forEach(System.out::println);

        List<ClientePremium> clientesPremium = fromArrayToList(new ClientePremium[]{new ClientePremium("Andres", "Guzman")});
        imprimirClientes(clientes);
        imprimirClientes(clientesLista);
        imprimirClientes(clientesPremium);

        System.out.println("Maximo de 1, 9 y 4 es: " + maximo(1, 9, 4));
        System.out.println("Maximo de 3.9, 11.6 y 7.78 es: " + maximo(3.9, 11.6, 7.78));
        System.out.println("Maximo de zanahoria, arandanos, y manzana es: " + maximo("zanahoria", "aranados", "manzana"));

    }

    public static <T> List<T> fromArrayToList(T[] c) {
        return Arrays.asList(c);
    }

    public static <T extends List<T> fromArrayToList(T[] c){
        return Arrays.asList(c);
    }
}
