package com.foodsquare.servidor;

import com.foodsquare.modelo.FoodSquare;
import com.foodsquare.modelo.Restaurante;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class persistencia {
    //Variables del modelo
    private FoodSquare cc;

    //Variables de conexion e in/out
    private String texto;


    InputStreamReader isr = new InputStreamReader(System.in);
    BufferedReader br = new BufferedReader (isr);

    public persistencia() throws IOException {

        System.out.print("ingrese usuario: ");
        texto = br.readLine();

        if(texto.equals("admin")) {
            System.out.print("ingrese contrasena: ");
            texto = br.readLine();
            if (texto.equals("admin")){
                System.out.println("\n.:: Bienvenido Admin ::.");
                setup();
            }
        }else {
            System.out.println("Error");
            System.exit(0);
        }
    }

    private void setup() throws IOException {

        while(true){
            System.out.print("desea cargar una estructura en memoria? (Y/n): ");
            texto=br.readLine();
            if(texto.equals("y")||texto.equals("Y")){
                System.out.print("ingrese el nombre de la estructura");
                texto=br.readLine();
                cargarEstructura(texto);
                break;
            }else if(texto.equals("N")||texto.equals("n")){
                //Configuracion de un nuevo sistema
                cc = new FoodSquare();
                System.out.println(".:: Nuevo Sistema FoodSquare ::.");

                System.out.print("ingrese el nombre de la plazoleta de comidas: ");
                texto=br.readLine();
                cc.setNombreCC(texto);


                boolean noSalir=true;
                while(noSalir){
                    System.out.println("registro de restaurantes: ");

                    Restaurante r = new Restaurante();

                    System.out.println("\tingreso de un nuevo restaurante ");
                    System.out.print("\tnombre de restaurante: ");
                    texto=br.readLine();
                    r.setNombre(texto);

                    System.out.print("\tingrese la clave de acceso para el restaurante: ");
                    texto=br.readLine();
                    r.setContraseña(texto);

                    cc.addRestaurante(r);

                    while (noSalir){
                        System.out.print("desea agregar otro restaurante a la plazoleta de comidas? (Y/n): ");
                        texto=br.readLine();
                        if(texto.equals("y")||texto.equals("Y")){
                            break;
                        }else if(texto.equals("N")||texto.equals("n")){

                            noSalir=false;
                        }else {
                            System.out.println("lo siento no te he entendido");
                        }
                    }
                }
                guardarFoodSquare();

                break;
            }else {
                System.out.println("lo siento no te he entendido");
            }

        }
    }

    private void guardarFoodSquare() {
        /*
        Gson gson=new Gson();
        String s = gson.toJson(this);
        */

        Gson gsonPrint=new GsonBuilder().setPrettyPrinting().create();
        String print = gsonPrint.toJson(cc);

        System.out.println();
        System.out.println(print);
    }

    private void cargarEstructura(String texto) {
        // CArgar el .json con los datos del restaurante
        System.out.println("Aqui se carga la estructura");
    }

    public void iniciarConexion(){
        try {
            ServerSocket server;
            Socket socket;
            int puerto = 9000;
            PrintStream salida;
            BufferedReader entrada;

            server = new ServerSocket(puerto);
            socket = new Socket();
            System.out.println("Servidor iniciado");
            socket = server.accept();
            entrada = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String peticion = entrada.readLine();


            switch (Integer.parseInt(peticion)) {
                case 1:
                    System.out.println(peticion);

                    salida = new PrintStream(socket.getOutputStream());
                    salida.println("Listar productos");
                    socket.close();
                    break;
                case 2:
                    System.out.println(peticion);

                    salida = new PrintStream(socket.getOutputStream());
                    salida.println("Guardar nuevo producto");

                    peticion = entrada.readLine();

                    salida.println("Producto guardado");

                    socket.close();
                    break;
                case 3:
                    System.out.println(peticion);

                    salida = new PrintStream(socket.getOutputStream());
                    salida.println("Listar restaurantes");
                    socket.close();
                    break;
                default:
                    System.out.println(peticion);

                    salida = new PrintStream(socket.getOutputStream());
                    salida.print("Peticiones: " +
                            "1. Listar productos\t" +
                            "2. Guardar nuevo producto\t" +
                            "3. Listar restaurantes");
                    //socket.close();

                    break;
            }
        } catch (Exception e) {
        }
    }

    @Override
    public String toString() {
        return "persistencia{" +
                "texto='" + texto + '\'' +
                ", cc=" + cc +
                '}';
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public FoodSquare getCc() {
        return cc;
    }

    public void setCc(FoodSquare cc) {
        this.cc = cc;
    }

    public boolean guardarProducto(String json){

        return true;
    }
}
