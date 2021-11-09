package com.foodsquare.modelo;

import java.util.Vector;

public class FoodSquare {
    String nombreCC;
    String contraseña;
    Vector<Restaurante> restaurantes;
    Vector<Pedido> pedidos;

    public FoodSquare(String nombreCC, String contraseña, Vector<Restaurante> restaurantes, Vector<Pedido> pedidos) {
        this.nombreCC = nombreCC;
        this.contraseña = contraseña;
        this.restaurantes = restaurantes;
        this.pedidos = pedidos;
    }

    @Override
    public String toString() {
        return "FoodSquare{" +
                "nombreCC='" + nombreCC + '\'' +
                ", contraseña='" + contraseña + '\'' +
                ", restaurantes=" + restaurantes +
                ", pedidos=" + pedidos +
                '}';
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
}
