
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
     * Cantidad del producto minima que puede haber del producto
     */
    private int cantidadMin;
    /**
     * Cantidad del producto maxima que puede haber del producto
     */
    private int cantidadMax;
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
    public final static double INTERVALO_DESCUENTO = 0.5;

    public Producto(String nombreProducto,int precio,int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.precioMin = calcularPrecioMin(precio);
        this.precioMax = calcularPrecioMax(precio);
        this.cantidad = cantidad;
        this.cantidadMax = calcularCantidadMax(cantidad);
        this.cantidadMin = calcularCantidadMin(cantidad);
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

    public int getCantidadMin() {
        return cantidadMin;
    }

    public int getCantidadMax() {
        return cantidadMax;
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

    public void setCantidadMax(int cantidadMax) {
        this.cantidadMax = cantidadMax;
    }

    public void setCantidadMin(int cantidadMin) {
        this.cantidadMin = cantidadMin;
    }

    // OTROS

    /**
     * Calcula el precio maximo que puede alcanzar el producto
     * @param precio precio base del producto
     * @return el precio maximo
     */
    public static int calcularPrecioMax(int precio) {
        return (int) (precio + (precio * INTERVALO_DESCUENTO));
    }
    /**
     * Calcula el precio minimo que puede alcanzar el producto
     * @param precio precio base del producto
     * @return el precio minimo
     */
    public static int calcularPrecioMin(int precio) {
        return (int) (precio - (precio * INTERVALO_DESCUENTO));
    }

    /**
     * Calcula la cantidad maxima que puede alcanzar el producto
     * @param cantidad cantidad base del producto
     * @return la cantidad maxima
     */
    public static int calcularCantidadMax(int cantidad) {
        return (int) (cantidad + cantidad);
    }
    /**
     * Calcula la cantidad minima que puede alcanzar el producto
     * @param cantidad cantidad base del producto
     * @return la cantidad minima
     */
    public static int calcularCantidadMin(int cantidad) {
        return (int) (cantidad - (cantidad/3));
    }

}
