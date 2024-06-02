package com.lucia.actividades;

import java.util.*;

import com.lucia.interfaz.PanelPerfil;
import com.lucia.interfaz.PanelProducto;
import com.lucia.perfil.Perfil;
import com.lucia.producto.Producto;

public class MercadoActividad {

    private static List<PanelProducto> observadores = new ArrayList<>();

    /**
     * Realiza todas la acciones necesaria para la compra de un producto
     * @param producto que se va a comprar
     * @param cantidadSeleccionada del producto
     * @param precioTotal del producto
     * @param perfil partida que va a relaizar la compra
     */
    public static void realizarCompra(Producto producto, int cantidadSeleccionada, int precioTotal, Perfil perfil) {

        //Fondos
        perfil.setFondos(perfil.getFondos() - precioTotal);
        perfil.setPerdidas(perfil.getPerdidas() + precioTotal);

        //Cantidad Mercado
        producto.setCantidad(producto.getCantidad() - cantidadSeleccionada);

        //Cantidad Almacen
        perfil.getAlmacen().setEspacioEnUso(perfil.getAlmacen().getEspacioEnUso() + cantidadSeleccionada);
        Producto productoAlmacen = perfil.getAlmacen().getProducto(producto.getNombreProducto());
        productoAlmacen.setCantidad(cantidadSeleccionada + productoAlmacen.getCantidad());

        // Actualizar infromacion
        PanelPerfil panelPerfil = PanelPerfil.getInstance();
        panelPerfil.actualizarInformacion();

        notificarObservadores();
    }

    /**
     * Realiza todas la acciones necesaria para la venta de un producto
     * @param producto que se va a vender
     * @param cantidadSeleccionada del producto
     * @param precioTotal del producto
     * @param perfil partida que va a relaizar la venta
     */
    public static void realizarVenta(Producto producto, int cantidadSeleccionada, int precioTotal, Perfil perfil) {

        //Fondos
        perfil.setFondos(perfil.getFondos()+ precioTotal);
        perfil.setGanancias(perfil.getGanancias() + precioTotal);

        //Cantidad Almacen
        producto.setCantidad(producto.getCantidad() - cantidadSeleccionada);
        perfil.getAlmacen().setEspacioEnUso(perfil.getAlmacen().getEspacioEnUso() - cantidadSeleccionada);

        //Cantidad Mercado
        Producto productoMercado = perfil.getMercado().getProducto(producto.getNombreProducto());
        productoMercado.setCantidad(cantidadSeleccionada + productoMercado.getCantidad());

        // Actualizar infromacion
        PanelPerfil panelPerfil = PanelPerfil.getInstance();
        panelPerfil.actualizarInformacion();

        notificarObservadores();
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
     * Circula por los productos del mercado renovando sus precios y cantidades
     */
    public static void actualizarProductos(Map<String, Producto> productosMercado, Map<String, Producto> productosAlmacen) {
        for (Map.Entry<String, Producto> entry : productosMercado.entrySet()) {
            Producto productoMercado = entry.getValue();
            Producto productoAlmacen = productosAlmacen.get(entry.getKey());
    
            int nuevaCantidad = renovarCantidades(productoMercado.getCantidadMax(), productoMercado.getCantidadMin());
            productoMercado.setCantidad(nuevaCantidad);
    
            int nuevoPrecio = cambiarPrecios(productoMercado.getPrecioMax(), productoMercado.getPrecioMin());
            productoMercado.setPrecio(nuevoPrecio);
            productoAlmacen.setPrecio(nuevoPrecio);
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
            observador.actualizarCantidad();
        }
    }
    
}
