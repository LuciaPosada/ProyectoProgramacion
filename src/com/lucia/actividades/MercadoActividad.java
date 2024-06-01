package com.lucia.actividades;

import java.util.*;

import com.lucia.interfaz.PanelProducto;
import com.lucia.producto.Producto;

public class MercadoActividad {

    private static List<PanelProducto> observadores = new ArrayList<>();

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
     * Circula por los productos del mercado renovando sus precios y cantidades
     */
    public static void actualizarProductos(Map<String, Producto> productos) {
        for (Producto producto : productos.values()) {
            int nuevoPrecio = cambiarPrecios(producto.getPrecioMax(), producto.getPrecioMin());
            producto.setPrecio(nuevoPrecio);
    
            int nuevaCantidad = renovarCantidades(producto.getCantidadMax(), producto.getCantidadMin());
            producto.setCantidad(nuevaCantidad);
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
