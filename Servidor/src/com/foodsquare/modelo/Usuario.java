package com.foodsquare.modelo;

public class Usuario {
    private String nombre;
    private int telefono;

    public Usuario() {
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                '}';
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public Usuario(String nombre, int telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
    }
}
