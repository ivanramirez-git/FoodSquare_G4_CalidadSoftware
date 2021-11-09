package com.foodsquare;

import com.foodsquare.clienterestaurante.conexion.conectorRestaurante;
import com.foodsquare.modelo.Ingrediente;
import com.foodsquare.modelo.Pedido;
import com.foodsquare.modelo.Producto;
import com.foodsquare.modelo.Restaurante;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

public class ClienteRestaurante {

    Restaurante restaurante= new Restaurante();

    public static void main(String[] args) throws IOException {

        // write your code here
        setup();
        System.out.println();


        Vector<Producto> productos = new Vector<Producto>();
        Vector<Pedido> pedidos;

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        String texto;
        float flotante;
        int entero;

        while (true){
            menu();
            texto = br.readLine();
            if(texto.equals("1")||texto.equals("0")||texto.equals("2")){
                switch (Integer.parseInt(texto)){
                    case 1:
                        System.out.println();
                        System.out.println("Ingresar producto");

                        //Aqui ingresar productos
                        Producto p = new Producto();

                        System.out.print("Nombre: ");
                        texto= br.readLine();
                        p.setNombre(texto);

                        System.out.print("Descripcion: ");
                        texto= br.readLine();
                        p.setDescripcion(texto);

                        System.out.print("Ruta de la imagen principal: ");
                        texto= br.readLine();
                        p.setRutaImagen(texto);

                        Vector<Ingrediente> ingredientes = new Vector<Ingrediente>();
                        System.out.println("Ingredientes: ");
                        int contador=0;
                        boolean continuar=true;
                        //sc.nextLine();
                        while(continuar) {

                            System.out.println();
                            Ingrediente i = new Ingrediente();
                            contador++;
                            System.out.println("\t"+contador + ". ingrediente.");

                            System.out.print("\t\tNombre del ingrediente: ");
                            texto = br.readLine();
                            i.setNombre(texto);

                            System.out.print("\t\tRuta de la imagen del ingrediente: ");
                            texto = br.readLine();
                            i.setRutaIngrediente(texto);

                            ingredientes.add(i);

                            //texto=sc.nextLine();
                            while(continuar) {
                                System.out.print("Desea agregar un nuevo ingrediente? (Y/n): ");
                                texto=br.readLine();
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
                            texto=br.readLine();
                            if (texto.equals("y") || texto.equals("Y")) {
                                Gson gson = new Gson();
                                String jsonString = gson.toJson(productos);
                                //System.out.println(jsonString);

                                enviarPeticion("2");


                                conectorRestaurante c = new conectorRestaurante();
                                c.nuevoProducto_enviarServidor(jsonString);


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
    private static void setup() throws IOException {

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader (isr);

        System.out.println(".:: Configuracion ::.");
        System.out.println();
        System.out.println(".:: Seleccione un restaurante de la lista ::.");
        String id_peticion = br.readLine();
        enviarPeticion(id_peticion);

    }

    private static void enviarPeticion(String id_peticion) {
        conectorRestaurante c = new conectorRestaurante();
        c.peticion_idPeticion(id_peticion);
    }
}
