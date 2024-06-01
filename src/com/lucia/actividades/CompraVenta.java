package com.lucia.actividades;

public class CompraVenta {

    /**
     * Reduce los fondos disponibles al gastar una cierta cantidad de dinero
     * @param fondos Los fondos disponibles antes de gastar el dinero
     * @param precioTotal La cantidad de dinero a gastar
     * @return Los fondos restantes después de gastar el dinero
     */
    public static int gastarDinero(int fondos,int precioTotal){
        return fondos - precioTotal;
    }

    /**
     * Aumenta los fondos disponibles al ganar una cierta cantidad de dinero
     * @param fondos Los fondos disponibles antes de ganar el dinero
     * @param precioTotal La cantidad de dinero a ganar
     * @return Los fondos restantes después de ganar el dinero
     */
    public static int ganarDinero(int fondos,int precioTotal){
        return fondos + precioTotal;
    }

    /**
     * Aumenta la cantidad almacenada de un producto 
     * @param cantAumentar La cantidad a almacenar del producto
     * @param cantAlmacenada La cantidad actualmente almacenada del producto
     * @return La nueva cantidad almacenada después de aumentar la cantidad especificada
     */
    public static int aumentarCantidadProductoAlmacenado(int cantAumentar,int cantAlmacenada){
        return cantAlmacenada + cantAumentar;
    }

     /**
     * Reduce la cantidad almacenada de un producto 
     * @param cantReducir La cantidad a reducir del producto almacenado
     * @param cantAlmacenada La cantidad actualmente almacenada del producto
     * @return La nueva cantidad almacenada después de reducir la cantidad especificada
     */
    public static int reducirCantidadProductoAlmacenado(int cantReducir,int cantAlmacenada){
        return cantAlmacenada - cantReducir;
    }

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
