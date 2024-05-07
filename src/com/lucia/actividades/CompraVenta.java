package com.lucia.actividades;

public class CompraVenta {

    /**
     * Calcula el precio total basado en la cantidad a comprar y el precio por unidad
     * @param cantidadComprar cantidad del producto a comprar
     * @param precioUnidad precio del producto a comprar
     * @return precio total de la compra
     */
    public static int calcularPrecioTotal (int cantidadComprar,int precioUnidad){
        return cantidadComprar*precioUnidad;
    }
    
}
