package com.lucia.actividades;

import java.util.HashMap;
import java.util.Random;

import com.lucia.producto.Producto;

public class Mercado {

    private static HashMap<String,Producto> procuctosEnVenta;

    // CONSTRUCTOR

    public Mercado() {
        this.procuctosEnVenta = new HashMap<>();
    }

    /**
     * Genera un nuevo precio aleatorio dentro del rango [precioMin, precioMax]
     * @param precio El precio actual
     * @param precioMax El precio máximo permitido
     * @param precioMin El precio mínimo permitido
     * @return El nuevo precio
     */
    public static int cambiarPrecios(int precio,int precioMax,int precioMin) {
        Random random = new Random();
        int precioNuevo = random.nextInt(precioMax - precioMin + 1) + precioMin;
        return precioNuevo;
    }
}
