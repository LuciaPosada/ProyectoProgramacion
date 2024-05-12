package com.lucia.actividades;

import java.util.HashMap;
import java.util.Random;

import com.lucia.producto.Producto;

public class Mercado {

    private static HashMap<String, Producto> productosEnVenta = new HashMap<>();

    // CONSTRUCTOR

    public Mercado() {
        añadirProductos();
    }

    /**
     * Añade productos predefinidos al map de productos en venta
     */
    private static void añadirProductos() { // ToDo: Cambiar los placeholders
        productosEnVenta.put("Prueba1", new Producto("Prueba1", 10, 5));
        productosEnVenta.put("Prueba2", new Producto("Prueba2", 15, 25));
        productosEnVenta.put("Prueba3", new Producto("Prueba3", 45, 7));
        productosEnVenta.put("Prueba5", new Producto("Prueba5", 35, 8));
        productosEnVenta.put("Prueba6", new Producto("Prueba6", 95, 1));
        productosEnVenta.put("Prueba7", new Producto("Prueba7", 36, 19));
        productosEnVenta.put("Prueba8", new Producto("Prueba8", 104, 36));
        productosEnVenta.put("Prueba9", new Producto("Prueba9", 265, 3));
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
