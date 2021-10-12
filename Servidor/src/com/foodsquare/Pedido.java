package com.foodsquare;

import java.util.Vector;

public class Pedido {
    private Usuario usuario;
    private Vector<Restaurante> restaurantes;

    @Override
    public String toString() {
        return "Pedido{" +
                "usuario=" + usuario +
                ", restaurantes=" + restaurantes +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vector<Restaurante> getRestaurantes() {
        return restaurantes;
    }

    public void setRestaurantes(Vector<Restaurante> restaurantes) {
        this.restaurantes = restaurantes;
    }

    public Pedido(Usuario usuario, Vector<Restaurante> restaurantes) {
        this.usuario = usuario;
        this.restaurantes = restaurantes;
    }
}

