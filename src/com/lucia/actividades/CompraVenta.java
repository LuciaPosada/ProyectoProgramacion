package com.lucia.actividades;

public class CompraVenta {

    /**
     * Comprueba si hay suficiente espacio disponible en el almacén para comprar la cantidad requerida de productos
     * @param espcioAlmacen La cantidad total de espacio disponible en el almacén
     * @param cantidadComprar La cantidad de productos que se desea comprar
     * @return true si hay suficiente espacio | false si no hay suficiente espacio
     */
    public static boolean comprobarEspacioDisponible(int espcioAlmacen,int cantidadComprar){
        return cantidadComprar<= espcioAlmacen;
    }

    /**
     * Metodo que comprueba si el jugador tiene suficientes fondos para realizar la compra
     * @param precioTotal  el precio total de la compra a realizar
     * @param fondosPerfil los fondos disponibles en el perfil del jugador
     * @return true si el usuario tiene suficientes fondos para realizar la compra, false en caso contrario
     */
    public static boolean comprobarDineroDisponible(int precioTotal,int fondosPerfil){
        return precioTotal<= fondosPerfil;
    }

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
