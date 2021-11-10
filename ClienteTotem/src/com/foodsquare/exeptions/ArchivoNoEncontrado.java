package com.foodsquare.exeptions;

public class ArchivoNoEncontrado extends RuntimeException {
    public ArchivoNoEncontrado(String mensaje) { super(mensaje); }
}
