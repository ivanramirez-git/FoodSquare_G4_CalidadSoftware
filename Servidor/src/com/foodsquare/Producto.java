package com.foodsquare;

import java.util.Vector;

public class Producto {
    private String nombre;
    private float precio;
    private String descripcion;
    private Vector<Ingrediente> ingredientes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Vector<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Vector<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Producto(String nombre, float precio, String descripcion, Vector<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.ingredientes = ingredientes;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", descripcion='" + descripcion + '\'' +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
