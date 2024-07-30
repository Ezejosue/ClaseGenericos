package org.generic.poointerfaces;

public class Cliente extends BaseEntity{
    private String nombre;
    private String tipo;

    public Cliente(String nombre, String tipo) {
        super();
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nombre=" + nombre + ", tipo=" + tipo + '}';
    }
}
