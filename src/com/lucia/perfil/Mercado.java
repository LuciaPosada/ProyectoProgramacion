package com.lucia.perfil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lucia.producto.Producto;

public class Mercado implements Serializable{
    /**
     * Mapa para almacenar los productos a comprar
     */
    private static HashMap<String, Producto> productosEnVenta = new HashMap<>();

    // CONSTRUCTOR

    public Mercado() {
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
        productosEnVenta.put("Consola", new Producto("Consola", 698, 3));
    }

    /**
     * Obtiene el mapa de productos en venta
     * @return Un mapa de productos
     */
    public static Map<String, Producto> getProductosEnVenta() {
        return productosEnVenta;
    }

    /**
     * Obtiene el producto que coincide con la clave dada
     * @param nombre la clave del producto
     * @return el producto que coincide con la clave, o null si no se encuentra
     */
    public Producto getProducto(String nombre) {
        return productosEnVenta.get(nombre);
    }
    
}
