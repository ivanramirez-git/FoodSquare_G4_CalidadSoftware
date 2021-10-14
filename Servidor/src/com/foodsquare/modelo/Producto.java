package com.foodsquare.modelo;

import java.util.Vector;

public class Producto {
    private String nombre;
    private String nombreRestaurante;
    private String descripcion;
    private String rutaImagen;
    private Vector<Ingrediente> ingredientes;

    public Producto() {
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombreRestaurante() {
        return nombreRestaurante;
    }

    public void setNombreRestaurante(String nombreRestaurante) {
        this.nombreRestaurante = nombreRestaurante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Vector<Ingrediente> getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(Vector<Ingrediente> ingredientes) {
        this.ingredientes = ingredientes;
    }

    public Producto(String nombre, String descripcion, String rutaImagen, Vector<Ingrediente> ingredientes) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.rutaImagen = rutaImagen;
        this.ingredientes = ingredientes;

    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", rutaImagen=" + rutaImagen +
                ", ingredientes=" + ingredientes +
                '}';
    }
}
