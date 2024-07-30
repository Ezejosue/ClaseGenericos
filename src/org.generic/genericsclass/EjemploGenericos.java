package org.generic.genericsclass;

public class EjemploGenericos {

    public static <T> void imprimirCamion(Camion<T> camion) {
        for (T a : camion) {
            if (a instanceof Animal) {
                System.out.println("Animal: " + ((Animal) a).getNombre() + " - " + ((Animal) a).getTipo());
            } else if (a instanceof Automovil) {
                System.out.println("Automovil: " + ((Automovil) a).getMarca());
            } else if (a instanceof Maquinaria) {
                System.out.println("Maquinaria: " + ((Maquinaria) a).getTipo());
            }
        }
    }


    public static void main(String[] args) {
        Camion<Animal> transporteCaballos = new Camion<>(5);
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquen", "Caballo"));
        transporteCaballos.add(new Animal("TopoCalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transporteMaquinaria = new Camion<>(3);
        transporteMaquinaria.add(new Maquinaria("Bulldozer"));
        transporteMaquinaria.add(new Maquinaria("Grúa Horquilla"));
        transporteMaquinaria.add(new Maquinaria("Perforadora"));

        imprimirCamion(transporteMaquinaria);

        Camion<Automovil> transporteAutomoviles = new Camion<>(3);
        transporteAutomoviles.add(new Automovil("Toyota"));
        transporteAutomoviles.add(new Automovil("Mitshubishi"));
        transporteAutomoviles.add(new Automovil("Chevrolet"));

        imprimirCamion(transporteAutomoviles);
    }
}
