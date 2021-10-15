package com.foodsquare.modelo;

import java.util.Vector;

public class Pedido {
    private Usuario usuario;
    private Vector<Producto> productos;
    private Boolean entregado;

    public Pedido() {
    }

    public Pedido(Usuario usuario, Vector<Producto> productos) {
        this.usuario = usuario;
        this.productos = productos;
    }

    public Boolean getEntregado() {
        return entregado;
    }

    public void setEntregado(Boolean entregado) {
        this.entregado = entregado;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "usuario=" + usuario +
                ", productos=" + productos +
                ", entregado=" + entregado +
                '}';
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Vector<Producto> getProductos() {
        return productos;
    }

    public void setProductos(Vector<Producto> productos) {
        this.productos = productos;
    }
}

