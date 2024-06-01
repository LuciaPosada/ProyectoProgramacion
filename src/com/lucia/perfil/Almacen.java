
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

}
