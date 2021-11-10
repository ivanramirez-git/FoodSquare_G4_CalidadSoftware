package com.foodsquare.modelo;

import java.util.Vector;

public class Restaurante {
    private String nombre;
    private String contrasena;
    private String urlImagen;
    private Vector<Producto> productos;

    public Restaurante(String nombre, String contraseña) {
        this.nombre = nombre;
        this.contrasena = contraseña;
        productos = new Vector<Producto>();
    }

    public Restaurante(String nombre, String contraseña, Vector<Producto> productos) {
        this.nombre = nombre;
        this.contrasena = contraseña;
        this.productos = productos;
    }



    public Restaurante() {
    }

    public Restaurante(String nombre, String contraseña, String urlImage) {
        this.nombre = nombre;
        this.contrasena = contraseña;
        this.urlImagen = urlImage;
    }

    public String getUrlImage() {
        return urlImagen;
    }

    public void setUrlImage(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Vector<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Vector<Producto> productos) {
        this.productos = productos;
    }

    public void addProducto(Producto producto){
        productos.add(producto);
    }

    public void removeProducto(Producto producto){
        productos.remove(producto);
    }

    @Override
    public String toString() {
        return "Restaurante{" +
                "nombre='" + nombre + '\'' +
                '}';
    }

}
