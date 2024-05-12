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

    /**
     * Genera aleatoriamente una nueva cantidad disponible del producto dentro del rango [cantidadMax, cantidadMin]
     * @param cantidadMax La cantidad maxima permitida
     * @param cantidadMin La cantidad minima permitida
     * @return La nueva cantidad
     */
    public static int renovarCantidades(int cantidadMax,int cantidadMin) {
        Random random = new Random();
        int cantNueva = random.nextInt(cantidadMax - cantidadMin + 1) + cantidadMin;
        return cantNueva;
    }
}
