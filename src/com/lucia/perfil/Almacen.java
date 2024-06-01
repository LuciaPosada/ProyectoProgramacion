package com.lucia.perfil;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.lucia.producto.Producto;

public class Almacen implements Serializable{

    /**
     * Espacio total para almacenar Productos
     */
    private int espacioTotal;
    /**
     * Espacio ocupado por Productos
     */
    private int espacioEnUso;
    /**
     * Mapa para almacenar los productos por nombre
     */
    private static HashMap<String, Producto> productosAlmacenados = new HashMap<>();
    
    // CONSTRUCTOR

    public Almacen() {
        this.espacioTotal = 50;
        this.espacioEnUso = 0;
        añadirProductos();
    }
    
    // GETTERS

    public int getEspacioTotal() {
        return espacioTotal;
    }

    public int getEspacioEnUso() {
        return espacioEnUso;
    }

    public static Map<String, Producto> getProductosAlmacenados() {
        return productosAlmacenados;
    }
    
    // SETTERS

    public void setEspacioTotal(int espacioTotal) {
        this.espacioTotal = espacioTotal;
    }

    public void setEspacioEnUso(int espacioEnUso) {
        this.espacioEnUso = espacioEnUso;
    }

    public static void setProductosAlmacenados(HashMap<String, Producto> productosAlmacenados) {
        Almacen.productosAlmacenados = productosAlmacenados;
    }

    // OTROS

    /**
     * Añade productos predefinidos al map de productos almacenados
     */
    private static void añadirProductos() {
        productosAlmacenados.put("Mechero", new Producto("Mechero", 10, 0));
        productosAlmacenados.put("Tetera", new Producto("Tetera", 34, 0));
        productosAlmacenados.put("Aceite", new Producto("Aceite", 57, 0));
        productosAlmacenados.put("Vestido", new Producto("Vestido", 85, 0));
        productosAlmacenados.put("Vino", new Producto("Vino", 130, 0));
        productosAlmacenados.put("Caviar", new Producto("Caviar", 200, 0));
        productosAlmacenados.put("Colgante", new Producto("Colgante", 404, 0));
        productosAlmacenados.put("Consola", new Producto("Consola", 698, 0));
    }

    /**
     * Obtiene el producto que coincide con la clave dada
     * @param nombre la clave del producto
     * @return el producto que coincide con la clave, o null si no se encuentra
     */
    public Producto getProducto(String nombre) {
        return productosAlmacenados.get(nombre);
    }
}
