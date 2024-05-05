
package com.lucia.producto;

public class Producto {
    /**
     * Nombre del producto
     */
    private String nombreProducto;
    /**
     * Cantidad del producto disponible
     */
    private int cantidad;
    /**
     * Precio unitario del producto
     */
    private int precio;
    /**
     * Precio unitario minimo que el producto puede alcanzar
     */
    private int precioMin;
    /**
     * Precio unitario maximo que el producto puede alcanzar
     */
    private int precioMax;
    /**
     * Porcentaje de descuento estático para calcular el precio mínimo y máximo.
     */
    public static double PORCENTAJE_DESCUENTO = 0.5;

    public Producto(String nombreProducto,int precio,int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.precioMin = calcularPrecioMin(precio);
        this.precioMax = calcularPrecioMax(precio);
        this.cantidad = cantidad;
    }

    // GETTER

    public String getNombreProducto() {
        return nombreProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public int getPrecioMin() {
        return precioMin;
    }

    public int getPrecioMax() {
        return precioMax;
    }

    public int getCantidad() {
        return cantidad;
    }
    
    // SETTER

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setPrecioMax(int precioMax) {
        this.precioMax = precioMax;
    }

    public void setPrecioMin(int precioMin) {
        this.precioMin = precioMin;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // OTROS

    /**
     * Calcula el precio maximo que puede alcanzar el producto
     * @param precio precio base del producto
     * @return el precio maximo
     */
    private static int calcularPrecioMax(int precio) {
        return (int) (precio + (precio * PORCENTAJE_DESCUENTO));
    }
    /**
     * Calcula el precio minimo que puede alcanzar el producto
     * @param precio precio base del producto
     * @return el precio minimo
     */
    private static int calcularPrecioMin(int precio) {
        return (int) (precio - (precio * PORCENTAJE_DESCUENTO));
    }

}
