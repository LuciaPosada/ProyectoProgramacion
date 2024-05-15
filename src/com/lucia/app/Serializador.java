package com.lucia.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Serializador {

    /**
     * Serializa el HashMap dado y lo guarda en el archivo especificado
     * @param <K> clave del HashMap
     * @param <T> datos guardados por el HashMap
     * @param archivo donde se guardan los datos
     * @param datos el HashMap a serializar y guardar
     */
    public static <K, T> void guardarDatos(String archivo,HashMap<K,T> datos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(datos);
            System.out.println("Datos guardado exitosamente");
        } catch (IOException e) {
            System.out.println("Error al guardar los datos");
           e.printStackTrace();                   
        }
    }

}