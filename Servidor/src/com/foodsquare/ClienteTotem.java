package com.foodsquare;

import com.google.gson.Gson;

import java.util.Scanner;
import java.util.Vector;

public class ClienteTotem {



    public static void main(String[] args) {
        // write your code here
        Vector<Usuario> usuarios;
        Scanner sc = new Scanner(System.in);
        String texto;

        while (true){
            menu();
            texto = sc.nextLine();
            if(texto.equals("1")||texto.equals("0")){
                switch (Integer.parseInt(texto)){
                    case 1:
                        System.out.println();
                        System.out.println("Inicio un nuevo pedido");

                        //Aqui ingresar pedido
                        listarProductos();


                        System.out.println();
                    break;
                    case 0:
                        System.out.println();
                        System.out.println("Gracias.");
                        System.out.println();
                    break;

                }
            } else {
                System.out.println("Por favor elija una opcion valida");
            }

        }

    }

    private static void listarProductos() {
        System.out.println("Se listan los productos");
    }

    private static void menu() {
        System.out.println(".:: Bienvenido ::.");
        System.out.println();
        System.out.println("1. Iniciar un pedido.");
        System.out.println("0. Cancelar.");
    }


}
