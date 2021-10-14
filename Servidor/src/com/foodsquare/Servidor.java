package com.foodsquare;

import com.foodsquare.conexion.conectorServidor;

public class Servidor {

    public static void main(String[] args) {
	// write your code here
        conectorServidor c = new conectorServidor();
        c.iniciar();

    }
}