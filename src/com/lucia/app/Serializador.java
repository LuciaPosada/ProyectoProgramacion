package com.lucia.app;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

    /**
     * Deserializa los datos del archivo especificado y los guarda en un HashMap
     * @param <K> clave del HashMap
     * @param <T> datos guardados por el HashMap
     * @param archivo de donde se cargan los datos
     * @return el HashMap a deserializar y cargar
     */
    public static  <K, T> HashMap<K,T> cargarDatos(String archivo) {

        HashMap<K,T> datos = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(archivo))) {
            Object obj = ois.readObject();
            if (obj instanceof HashMap) {
                datos = (HashMap<K,T>) obj;
                System.out.println("Datos cargados exitosamente");
            } else {
                System.out.println("El objeto leído no es un HashMap<K,T>");
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar datos");
            e.printStackTrace();
        }

        return datos;
    }
}