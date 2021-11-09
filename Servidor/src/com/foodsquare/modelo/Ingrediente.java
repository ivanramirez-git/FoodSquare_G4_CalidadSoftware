package com.foodsquare.modelo;

public class Ingrediente {
    private String nombre;
    private String rutaIngrediente;

    public Ingrediente() {
    }

    public Ingrediente(String nombre, String rutaIngrediente) {
        this.nombre = nombre;
        this.rutaIngrediente = rutaIngrediente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaIngrediente() {
        return rutaIngrediente;
    }

    public void setRutaIngrediente(String rutaIngrediente) {
        this.rutaIngrediente = rutaIngrediente;
    }
}
