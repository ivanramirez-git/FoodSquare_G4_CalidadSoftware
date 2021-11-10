package com.foodsquare.persistidor;

// gson
import com.foodsquare.exeptions.ArchivoNoEncontrado;
import com.foodsquare.modelo.FoodSquare;
import com.google.gson.Gson;

import java.io.*;

public class  PersistenciaLocal   {

    public FoodSquare  cargarFoodSquare(){
        // TODO - implement PersistenciaLocal.cargarFoodSquare
        try {
            BufferedReader br = new BufferedReader(new FileReader("resources/foodsquare.json"));
            FoodSquare foodSquare = new FoodSquare();
            Gson gson = new Gson();
            return gson.fromJson(br, FoodSquare.class);
        } catch (FileNotFoundException e) {
            return null;
        }
    }

    public void guardarFoodSquare(FoodSquare foodSquare){
        // TODO - implement PersistenciaLocal.guardarFoodSquare

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("resources/foodsquare.json"));
            Gson gson = new Gson();
            // Guardar toda la informacion del foodSquare en el archivo usando el formato JSON
            gson.toJson(foodSquare, bw);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
