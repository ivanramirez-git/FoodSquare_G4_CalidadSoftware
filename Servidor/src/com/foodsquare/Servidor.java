package com.foodsquare;

import com.foodsquare.servidor.persistencia;

import java.io.IOException;

public class Servidor {

    public static void main(String[] args) throws IOException {
	// write your code here
        //setup();
        persistencia p = new persistencia();
        while(true)
            p.iniciarConexion();
    }
}