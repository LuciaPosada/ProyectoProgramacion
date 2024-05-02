
package com.lucia.producto;

public class Producto {
    
    private String nombreProducto;

    private int cantidad;
    
    private int precio;

    private int precioMin;

    private int precioMax;

    public static double PORCENTAJE_DESCUENTO = 0.5;

    public Producto(String nombreProducto,int precio,int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.precioMin = calcularPrecioMin(precio);
        this.precioMax = calcularPrecioMax(precio);
        this.cantidad = cantidad;
    }

}
