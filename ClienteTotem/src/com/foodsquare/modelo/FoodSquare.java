package com.foodsquare.modelo;

import java.util.Vector;

public class FoodSquare {
    String nombreCC;
    String contrasena;
    Vector<Restaurante> restaurantes;
    Vector<Pedido> pedidos;

    public FoodSquare(String nombreCC, String contraseña, Vector<Restaurante> restaurantes, Vector<Pedido> pedidos) {
        this.nombreCC = nombreCC;
        this.contrasena = contraseña;
        this.restaurantes = restaurantes;
        this.pedidos = pedidos;
    }

    public void addRestaurante(Restaurante r){
        restaurantes.add(r);
    }

    public void addPedido(Pedido p){
        pedidos.add(p);
    }

    public String getNombreCC() {
        return nombreCC;
    }

    public void setNombreCC(String nombreCC) {
        this.nombreCC = nombreCC;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Vector<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Vector<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Vector<Pedido> getPedidos() {
        return pedidos;
    }

    public void setPedidos(Vector<Pedido> pedidos) {
        this.pedidos = pedidos;
    }

    public FoodSquare() {
        restaurantes = new Vector<Restaurante>();
        pedidos = new Vector<Pedido>();
    }

    public Restaurante buscarRestaurante(String nombreBuscar) {
        for (Restaurante r : restaurantes) {
            if (r.getNombre().equals(nombreBuscar)) {
                return r;
            }
        }
        return null;
    }

    public void eliminarRestaurante(String nombre){
        for(Restaurante r : restaurantes){
            if(r.getNombre().equals(nombre)){
                restaurantes.remove(r);
            }
        }
    }

    @Override
    public String toString() {
        return "FoodSquare{" +
                "nombreCC='" + nombreCC + '\'' +
                ", restaurantes=" + restaurantes +
                '}';
    }
}
