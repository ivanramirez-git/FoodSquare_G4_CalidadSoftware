package com.foodsquare.conexion;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class conectorRestaurante {

    Socket socket_restaurante;
    int puerto = 9000;
    String ip_server = "192.168.0.103";
    BufferedReader entrada;
    PrintStream salida;

    public void nuevoProducto_enviarServidor(String mensaje) {
        try {
            socket_restaurante = new Socket(ip_server, puerto);

            entrada = new BufferedReader(new InputStreamReader(socket_restaurante.getInputStream()));

            System.out.println(mensaje);

            salida = new PrintStream(socket_restaurante.getOutputStream());

            salida.println(mensaje);

            String msg = entrada.readLine();

            System.out.println(msg);

            entrada.close();
            salida.close();
            socket_restaurante.close();
        }catch (Exception e){};
    }

    public void peticion_idPeticion(String peticionID) {
        try {
            socket_restaurante = new Socket(ip_server, puerto);
            entrada = new BufferedReader(new InputStreamReader(socket_restaurante.getInputStream()));
            System.out.println(peticionID);
            salida = new PrintStream(socket_restaurante.getOutputStream());
            salida.println(peticionID);
            String msg = entrada.readLine();
            System.out.println(msg);
            entrada.close();
            salida.close();
            socket_restaurante.close();
        }catch (Exception e){
            System.out.println("Error de Conexion");
        };
    }
}
