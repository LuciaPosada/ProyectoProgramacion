
package com.lucia.perfil;

import java.util.HashMap;

import com.lucia.producto.Producto;

public class Almacen {
    /**
     * Espacio disponible para almacenar Productos
     */
    private int espacioAlmacen;
    /**
     * Mapa para almacenar los productos por nombre
     */
    private HashMap<String,Producto> procuctosAlmacenados;
    
    // CONSTRUCTOR

    public Almacen() {
        this.espacioAlmacen = 50;
        this.procuctosAlmacenados = new HashMap<>();
    }
    
    // GETTERS

    public int getEspacioAlmacen() {
        return espacioAlmacen;
    }

    public HashMap<String, Producto> getProcuctosAlmacenados() {
        return procuctosAlmacenados;
    }
    
    // SETTERS

    public void setEspacioAlmacen(int espacioAlmacen) {
        this.espacioAlmacen = espacioAlmacen;
    }

    public void setProcuctosAlmacenados(HashMap<String, Producto> procuctosAlmacenados) {
        this.procuctosAlmacenados = procuctosAlmacenados;
    }

}
