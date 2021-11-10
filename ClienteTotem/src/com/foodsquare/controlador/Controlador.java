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
            // Pedir url del la plazoleta de comidas
            vista.mostrarMensaje("Ingrese la url de la imagen de la nueva plazoleta de comidas: ");
            String urlPlazoleta = vista.leerCadena();
            fs.setUrlImage(urlPlazoleta);


        }else {
            vista.mostrarMensajeln("Datos de FoodSquare encontrados");
            // Pedir nombre del plazoleta de comidas
            vista.mostrarMensaje("Ingrese el nombre del la plazoleta de comidas: ");
            String nombrePlazoleta = vista.leerCadena();

            // Pedir contraseña
            vista.mostrarMensaje("Ingrese la contraseña: ");
            String contrasena = vista.leerCadena();

            // Validar datos

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

            // Validar datos nulos
            if (fs.getNombreCC().equals(null)) {
                vista.mostrarMensajeln("El nombre de la plazoleta no puede ser nulo");
                vista.mostrarMensajeln("Ingrese el nombre del la plazoleta de comidas");
                nombrePlazoleta = vista.leerCadena();
                fs.setNombreCC(nombrePlazoleta);
            }
            if (fs.getContrasena().equals(null)) {
                vista.mostrarMensajeln("La contraseña no puede ser nula");
                vista.mostrarMensajeln("Ingrese una contraseña adecuada: ");
                contrasena = vista.leerCadena();
                fs.setContrasena(contrasena);
            }
            if (fs.getUrlImage().equals(null)) {
                vista.mostrarMensajeln("La url de la imagen no puede ser nula");
                vista.mostrarMensajeln("Ingrese una url de imagen,banner, para plazoleta de comidas" +
                        ": ");
                String urlImage = vista.leerCadena();
                fs.setUrlImage(urlImage);
                persistidor.guardarFoodSquare(fs);
            }
        }

        // Menu
        int opcion = -1;
        do {
            vista.mostrarMensajeln("Bienvenido al FoodSquare");
            vista.mostrarMensajeln("1. Agregar restaurante");
            vista.mostrarMensajeln("2. Modificar restaurante");
            vista.mostrarMensajeln("3. Eliminar restaurante");
            vista.mostrarMensajeln("4. Buscar restaurante");
            vista.mostrarMensajeln("5. Listar restaurantes");
            vista.mostrarMensajeln("6. Salir y Guardar FoodSquare");
            vista.mostrarMensaje("Ingrese una opcion: ");
            opcion = vista.leerEntero();

            // Opciones con if
            if (opcion == 1) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombre = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la contraseña: ");
                String contrasenia = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la url de la Imagen del Restaurante: ");
                String urlImage = vista.leerCadena();
                Restaurante restaurante = new Restaurante(nombre, contrasenia, urlImage);
                fs.addRestaurante(restaurante);
                persistidor.guardarFoodSquare(fs);
                vista.mostrarMensajeln("Restaurante agregado");


            } else if (opcion == 2) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombre = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la contraseña: ");
                String contrasenia = vista.leerCadena();

                // Buscar restaurante
                Restaurante restaurante = fs.buscarRestaurante(nombre);
                if (restaurante == null) {
                    vista.mostrarMensajeln("No se encontro el restaurante");
                } else {
                    vista.mostrarMensajeln("Restaurante encontrado");
                    vista.mostrarMensajeln(restaurante.toString());
                    vista.mostrarMensaje("Ingrese la nueva contraseña: ");
                    String nuevaContrasenia = vista.leerCadena();
                    restaurante.setContrasena(nuevaContrasenia);
                    vista.mostrarMensajeln("Contraseña modificada");

                    vista.mostrarMensaje("Ingrese la nueva url de la imagen: ");
                    String nuevaUrlImage = vista.leerCadena();
                    restaurante.setUrlImage(nuevaUrlImage);
                    vista.mostrarMensajeln("Url de la imagen modificada");
                    persistidor.guardarFoodSquare(fs);
                    fs.modificarRestaurante(restaurante);
                    vista.mostrarMensajeln("Restaurante modificado");

                }
            } else if (opcion == 3) {
                vista.mostrarMensajeln("");
                vista.mostrarMensaje("Ingrese el nombre del restaurante: ");
                String nombreEliminar = vista.leerCadena();
                vista.mostrarMensaje("Ingrese la contraseña: ");
                String contraseniaEliminar = vista.leerCadena();
                Restaurante restauranteEliminar = fs.buscarRestaurante(nombreEliminar);
                if (restauranteEliminar != null) {
                    vista.mostrarMensajeln("Restaurante eliminado");
                    fs.eliminarRestaurante(restauranteEliminar);

                } else {
                    vista.mostrarMensajeln("Restaurante no encontrado");
                }
            } else if (opcion == 4) {
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

            } else if (opcion == 5) {
                vista.mostrarMensajeln("");
                vista.mostrarMensajeln("Listado de restaurantes");
                vista.mostrarMensajeln(fs.toString());

            } else if (opcion == 6) {
                persistidor.guardarFoodSquare(fs);
                vista.mostrarMensajeln("FoodSquare guardado");
                vista.mostrarMensaje("Gracias por usar FoodSquare");
            } else {
                vista.mostrarMensaje("Opcion incorrecta");
            }
        }while (opcion != 6);

    }
}
