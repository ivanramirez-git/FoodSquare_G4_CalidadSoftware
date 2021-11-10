package com.foodsquare.controlador;

import com.foodsquare.modelo.FoodSquare;
import com.foodsquare.modelo.Restaurante;
import com.foodsquare.persistidor.PersistenciaLocal;
import com.foodsquare.vista.VistaConsolaRestaurante;

public class Controlador {

    private FoodSquare fs;
    private PersistenciaLocal persistidor;
    private VistaConsolaRestaurante vista;

    public Controlador(){
        fs = new FoodSquare();
        persistidor = new PersistenciaLocal();
        vista = new VistaConsolaRestaurante();
    }

    public void iniciar() {
        // cargar datos
        fs = persistidor.cargarFoodSquare();
        if (fs == null) {
            fs = new FoodSquare();
            // Mensaje de Bienvenida
            vista.mostrarMensajeln("Bienvenido a FoodSquare");
            // Pedir nombre del plazoleta de comidas
            vista.mostrarMensaje("Ingrese el nombre del la plazoleta de la nueva comidas: ");
            String nombrePlazoleta = vista.leerCadena();
            fs.setNombreCC(nombrePlazoleta);
            // Pedir contraseña
            vista.mostrarMensaje("Ingrese una contraseña adecuada: ");
            String contrasena = vista.leerCadena();
            fs.setContrasena(contrasena);

        }else {
            vista.mostrarMensajeln("Datos de FoodSquare encontrados");
            // Pedir nombre del plazoleta de comidas
            vista.mostrarMensajeln("Ingrese el nombre del la plazoleta de comidas");
            String nombrePlazoleta = vista.leerCadena();

            // Pedir contraseña
            vista.mostrarMensajeln("Ingrese la contraseña");
            String contrasena = vista.leerCadena();

            // Verificar contraseña

            int intentos = 3;
            while (intentos > 0) {
                if (fs.getContrasena().equals(contrasena)) {
                    vista.mostrarMensajeln("Contraseña correcta");
                    break;
                } else {
                    vista.mostrarMensajeln("Contraseña incorrecta");
                    intentos--;
                }
            }
            if (intentos == 0) {
                vista.mostrarMensajeln("Se ha agotado el número de intentos");
                return;
            }
            //vista.mostrarMensajeln(fs.toString());
        }

        // Menu
        int opcion = -1;
        do {
            vista.mostrarMensajeln("Bienvenido al FoodSquare");
            vista.mostrarMensajeln("1. Agregar restaurante");
            vista.mostrarMensajeln("2. Eliminar restaurante");
            vista.mostrarMensajeln("3. Buscar restaurante");
            vista.mostrarMensajeln("4. Listar restaurantes");
            vista.mostrarMensajeln("5. Salir y Guardar FoodSquare");
            vista.mostrarMensaje("Ingrese una opcion: ");
            opcion = vista.leerEntero();

            // Opciones con if
            if (opcion == 1) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombre = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la contraseña: ");
                String contrasenia = vista.leerCadena();

                Restaurante restaurante = new Restaurante(nombre, contrasenia);

                fs.addRestaurante(restaurante);
                vista.mostrarMensaje("Restaurante agregado");
            } else if (opcion == 2) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombreEliminar = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la contraseña: ");
                String contraseniaEliminar = vista.leerCadena();
                Restaurante restauranteEliminar = fs.buscarRestaurante(nombreEliminar);
                if (restauranteEliminar != null) {
                    vista.mostrarMensaje("Restaurante eliminado");
                } else {
                    vista.mostrarMensaje("Restaurante no encontrado");
                }
            } else if (opcion == 3) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombreBuscar = vista.leerCadena();
                Restaurante restauranteBuscar = fs.buscarRestaurante(nombreBuscar);
                if (restauranteBuscar != null) {
                    vista.mostrarMensajeln("Restaurante encontrado");
                    vista.mostrarMensajeln(restauranteBuscar.toString());
                } else {
                    vista.mostrarMensajeln("Restaurante no encontrado");
                }

            } else if (opcion == 4) {
                vista.mostrarMensajeln("");
                vista.mostrarMensajeln("Listado de restaurantes");
                vista.mostrarMensajeln(fs.toString());

            } else if (opcion == 5) {
                persistidor.guardarFoodSquare(fs);
                vista.mostrarMensajeln("FoodSquare guardado");
                vista.mostrarMensaje("Gracias por usar FoodSquare");
            } else {
                vista.mostrarMensaje("Opcion incorrecta");
            }
        }while (opcion != 5);

    }
}
