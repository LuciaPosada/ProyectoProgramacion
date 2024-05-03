package com.lucia.actividades;

import java.util.HashMap;


import com.lucia.producto.Producto;

public class Mercado {

    private static HashMap<String,Producto> procuctosEnVenta;

    // CONSTRUCTOR

    public Mercado() {
        this.procuctosEnVenta = new HashMap<>();
    }

}
