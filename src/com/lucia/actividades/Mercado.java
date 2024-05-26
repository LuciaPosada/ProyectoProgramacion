package com.lucia.actividades;

import java.util.*;

import com.lucia.interfaz.PanelProducto;
import com.lucia.producto.Producto;

public class Mercado {

    private static HashMap<String, Producto> productosEnVenta = new HashMap<>();
    private static List<PanelProducto> observadores = new ArrayList<>();

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
     * Genera un nuevo precio aleatorio dentro del rango [precioMin, precioMax]
     * @param precioMax El precio máximo permitido
     * @param precioMin El precio mínimo permitido
     * @return El nuevo precio
     */
    public static int cambiarPrecios(int precioMax,int precioMin) {
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

    /**
     * 
     */
    public static void actualizarProductos() {
        for (Map.Entry<String, Producto> entry : productosEnVenta.entrySet()) {
            Producto producto = entry.getValue();

            int nuevoPrecio = cambiarPrecios(producto.getPrecioMax(), producto.getPrecioMin());
            producto.setPrecio(nuevoPrecio);

            int nuevaCantiadad = renovarCantidades();
            producto.setCantidad(nuevaCantiadad);
        }
        notificarObservadores();
    }
    

    // Solucion precaria y temporal
    public static void agregarObservador(PanelProducto observador) {
        observadores.add(observador);
    }

    public static void notificarObservadores() {
        for (PanelProducto observador : observadores) {
            observador.actualizarPrecio();
        }
    }
}
