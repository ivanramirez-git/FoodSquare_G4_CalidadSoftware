package com.foodsquare;

import java.util.Scanner;
import java.util.Vector;

//import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClienteRestaurante {
    public static void main(String[] args){
        // write your code here
        Vector<Producto> productos = new Vector<Producto>();
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
                        boolean continuar=true;
                        while(continuar) {

                            System.out.println();
                            Ingrediente i = new Ingrediente();
                            contador++;
                            System.out.println("\t"+contador + ". ingrediente.");

                            System.out.print("\t\tNombre del ingrediente: ");
                            sc.nextLine();
                            texto = sc.nextLine();
                            i.setNombre(texto);

                            System.out.print("\t\tCantidad del ingrediente: ");
                            entero = sc.nextInt();
                            i.setCantidad(entero);
                            ingredientes.add(i);


                            texto=sc.nextLine();
                            while(continuar) {
                                System.out.print("Desea agregar un nuevo ingrediente? (Y/n): ");
                                texto=sc.nextLine();
                                if (texto.equals("y") || texto.equals("Y")) {
                                    break;
                                } else if (texto.equals("N") || texto.equals("n")) {
                                    continuar=false;
                                } else {
                                    System.out.println("Lo siento no te he entendido.");
                                }
                            }

                        }

                        p.setIngredientes(ingredientes);
                        productos.add(p);
                        //System.out.println(productos.toString());

                        continuar=true;
                        while(continuar) {
                            System.out.println("Desea guardar y publicar el producto? (Y/n): ");
                            texto=sc.nextLine();
                            if (texto.equals("y") || texto.equals("Y")) {
                                Gson gson = new Gson();
                                String jsonString = gson.toJson(productos);
                                //System.out.println(jsonString);

                                conectorRestaurante c = new conectorRestaurante();
                                c.enviar_servidor(jsonString);

                                break;
                            } else if (texto.equals("N") || texto.equals("n")) {
                                continuar=false;
                            } else {
                                System.out.println("Lo siento no te he entendido.");
                            }
                        }

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
