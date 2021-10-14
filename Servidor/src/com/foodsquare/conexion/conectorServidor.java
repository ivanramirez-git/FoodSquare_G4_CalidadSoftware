package com.foodsquare.conexion;

import javax.naming.ldap.SortKey;
import java.net.*;
import java.io.*;

public class conectorServidor {

    ServerSocket server;
    Socket socket;
    int puerto = 9000;
    PrintStream salida;
    BufferedReader entrada;


    // ID de Peticiones
    /*
    1 Listar productos
    2 Guardar nuevo producto
    3 Listar restaurantes
     */
    public void iniciar() {
        while (true) {
            try {
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
                        salida.println("Peticiones: " +
                                "1. Listar productos\n" +
                                "2. Guardar nuevo producto\n" +
                                "3. Listar restaurantes");
                        socket.close();

                        break;
                }

            } catch (Exception e) {
            }
        }
    }
}
