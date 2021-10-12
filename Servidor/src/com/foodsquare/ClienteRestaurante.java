package com.foodsquare;

import java.util.Scanner;
import java.util.Vector;

public class ClienteRestaurante {
    public static void main(String[] args){
        // write your code here
        Vector<Usuario> usuarios;
        Scanner sc = new Scanner(System.in);
        String texto;

        while (true){
            menu();
            texto = sc.nextLine();
            if(texto.equals("1")||texto.equals("0")||texto.equals("2")){
                switch (Integer.parseInt(texto)){
                    case 1:
                        System.out.println();
                        System.out.println("Ingresar producto");

                        //Aqui ingresar pedido


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

    private static void menu() {
        System.out.println(".:: Restaurante ::.");
        System.out.println();
        System.out.println("1. Ingresar un producto.");
        System.out.println("2. Listar nuevos pedidoss.");
        System.out.println("0. Cancelar.");
    }
}
