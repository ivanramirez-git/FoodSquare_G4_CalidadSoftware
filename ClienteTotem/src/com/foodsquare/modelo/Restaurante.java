package com.foodsquare.modelo;

import java.util.Vector;

public class Restaurante {
    private String nombre;
    private String contraseña;
    private Vector<Producto> productos;

    public Restaurante(String nombre, String contraseña, Vector<Producto> productos) {
        this.nombre = nombre;
        this.contraseña = contraseña;
        this.productos = productos;
    }

    public Restaurante() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public Vector<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Vector<Producto> productos) {
        this.productos = productos;
    }
}
