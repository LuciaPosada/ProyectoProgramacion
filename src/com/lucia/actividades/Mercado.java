package com.lucia.actividades;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.lucia.producto.Producto;

public class Mercado {

    private static HashMap<String, Producto> productosEnVenta = new HashMap<>();

    // CONSTRUCTOR

    static {
        añadirProductos();
    }

    /**
     * Añade productos predefinidos al map de productos en venta
     */
    private static void añadirProductos() {
        productosEnVenta.put("Mechero", new Producto("Mechero", 10, 500));
        productosEnVenta.put("Tetera", new Producto("Tetera", 34, 250));
        productosEnVenta.put("Aceite", new Producto("Aceite", 57, 120));
        productosEnVenta.put("Vestido", new Producto("Vestido", 85, 85));
        productosEnVenta.put("Vino", new Producto("Vino", 130, 30));
        productosEnVenta.put("Caviar", new Producto("Caviar", 200, 19));
        productosEnVenta.put("Colgante", new Producto("Colgante", 404, 9));
        productosEnVenta.put("Consola", new Producto("Consola", 698, 5));
    }

    /**
     * Obtiene el mapa de productos en venta
     * @return Un mapa de productos
     */
    public static Map<String, Producto> getProductosEnVenta() {
        return productosEnVenta;
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
