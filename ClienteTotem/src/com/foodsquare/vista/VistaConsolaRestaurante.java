package com.foodsquare.vista;

import java.io.BufferedReader;

public class VistaConsolaRestaurante {

    // Funcion que recibe un String y lo muestra por pantalla
    public static void mostrarMensajeln(String mensaje) {
        System.out.println(mensaje);
    }

    // Funcion que recibe un String y lo muestra por pantalla sin salto de linea
    public static void mostrarMensaje(String mensaje) {
        System.out.print(mensaje);
    }

    // Funcion que retorna un String que lee por teclado
    public static String leer() {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        try {
            return br.readLine();
        } catch (Exception e) {
            return "";
        }
    }

    // Funcion que retorna un Entero que lee por teclado, valida que sea un entero y si no lo es lo vuelve a pedir
    public static int leerEntero() {
        int numero=0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Integer.parseInt(leer());
                valido = true;
            } catch (Exception e) {
                mostrarMensaje("\nERROR: No es un numero entero.\n");
            }
        }
        return numero;
    }

    // Funcion que retorna un Double que lee por teclado, valida que sea un Double y si no lo es lo vuelve a pedir
    public static double leerDouble() {
        double numero=0;
        boolean valido = false;
        while (!valido) {
            try {
                numero = Double.parseDouble(leer());
                valido = true;
            } catch (Exception e) {
                mostrarMensaje("\nERROR: No es un numero.\n");
            }
        }
        return numero;
    }

    // Funcion que retorna un Caracter que lee por teclado, valida que sea un Caracter y si no lo es lo vuelve a pedir
    public static char leerCaracter() {
        char caracter=' ';
        boolean valido = false;
        while (!valido) {
            try {
                caracter = leer().charAt(0);
                valido = true;
            } catch (Exception e) {
                mostrarMensaje("\nERROR: No es un caracter.\n");
            }
        }
        return caracter;
    }

    // Funcion que retorna un Booleano que lee por teclado, pide al usuario que ingrese una opcion valida que sea un (y o n) y si no lo es lo vuelve a pedir
    public static boolean leerBooleano() {
        boolean booleano=false;
        boolean valido = false;

        mostrarMensajeln("Ingrese una opcion valida (y/n): ");

        while (!valido) {
            try {
                String opcion = leer();
                if (opcion.equalsIgnoreCase("y") || opcion.equalsIgnoreCase("n")) {
                    booleano = opcion.equalsIgnoreCase("y");
                    valido = true;
                } else {
                    mostrarMensaje("\nERROR: No es una opcion valida.\n");
                }
            } catch (Exception e) {
                mostrarMensaje("\nERROR: No es una opcion valida.\n");
            }
        }
        return booleano;
    }

    // Funcion que retorna una cadena que permite espacios que lee por teclado, valida que sea una cadena y si no lo es lo vuelve a pedir
    public String leerCadena() {
        String cadena="";
        boolean valido = false;
        while (!valido) {
            try {
                cadena = leer();
                valido = true;
            } catch (Exception e) {
                mostrarMensaje("\nERROR: No es una cadena.\n");
            }
        }
        return cadena;
    }
}
