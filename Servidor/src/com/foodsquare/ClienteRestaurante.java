package com.foodsquare;

import java.util.Scanner;
import java.util.Vector;

public class ClienteRestaurante {
    public static void main(String[] args){
        // write your code here
        Vector<Producto> usuarios;
        Vector<Pedido> pedidos;
        Scanner sc = new Scanner(System.in);
        String texto;
        float flotante;
        int entero;

        while (true){
            menu();
            texto = sc.nextLine();
            if(texto.equals("1")||texto.equals("0")||texto.equals("2")){
                switch (Integer.parseInt(texto)){
                    case 1:
                        System.out.println();
                        System.out.println("Ingresar producto");

                        //Aqui ingresar productos
                        Producto p = new Producto();

                        System.out.print("Nombre: ");
                        texto= sc.nextLine();
                        p.setNombre(texto);

                        System.out.print("Descripcion: ");
                        texto= sc.nextLine();
                        p.setDescripcion(texto);

                        System.out.print("Precio: ");
                        flotante= sc.nextFloat();
                        p.setPrecio(flotante);

                        Vector<Ingrediente> ingredientes = new Vector<Ingrediente>();
                        System.out.println("Ingredientes: ");
                        int contador=0;
                        while(true) {

                            System.out.println();
                            Ingrediente i = new Ingrediente();
                            contador++;
                            System.out.println("\t"+contador + ". ingrediente.");

                            System.out.println("\t\tNombre del ingrediente: ");
                            texto = sc.nextLine();
                            i.setNombre(texto);

                            entero = sc.nextInt();
                            i.setCantidad(entero);
                            ingredientes.add(i);
                            break;
                        }
                        p.setIngredientes(ingredientes);




                        System.out.println();
                        break;
                    case 2:
                        System.out.println();
                        System.out.println("Listar nuevos pedidos");

                        //Aqui listar pedidos


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
