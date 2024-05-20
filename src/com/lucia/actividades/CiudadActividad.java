package com.lucia.actividades;

import java.util.Random;

public class CiudadActividad {

    private static int costoSalud = 100; // Costo Base

    private static int costoEspacio = 50; // Costo Base

    private static int costoLoteria = 500; // Costo Base

    public final static float MULTIPLICADOR_COSTO = 0.2f;

    public final static int CANTIDAD_AUMENTAR_SALUD = 20;

    public final static int CANTIDAD_AUMENTAR_ESPACIO = 25;

    public final static int MIN_GANANCIAS_LOTERIA = 50;

    public final static int MAX_GANANCIAS_LOTERIA = 1000000;

    /**
     * Aumenta la salud del jugador en 20
     * @param saludActual del perfil
     * @return la nueva cantidad de salud
     */
    public static int irHospital(int saludActual) {
        costoSalud = aumentarCosto("Salud");
        return saludActual+CANTIDAD_AUMENTAR_SALUD;
    }

    /**
     * Aumenta la cantidad de espacio de almacenaje del jugador en 25
     * @param espacioActual del perfil
     * @return la nueva cantidad de espacio del almacen
     */
    public static int aumentarEspacio(int espacioActual) {
        costoEspacio = aumentarCosto("Espacio");
        return espacioActual+CANTIDAD_AUMENTAR_ESPACIO;
    }

    /**
     * Genera la cantidad gana al jugar la loteria
     * @return el dinero ganado
     */
    public static int calcularPremioLoteria() { //ToDo: Buscar manera de reducir las posibilidades de generar cantidades altas
        costoLoteria = aumentarCosto("Loteria");
        Random random = new Random();
        int premio = random.nextInt(MAX_GANANCIAS_LOTERIA - MIN_GANANCIAS_LOTERIA + 1) + MIN_GANANCIAS_LOTERIA;
        return premio;
    }

    /**
     * Aumenta el costo financiero
     * @return el nuevo costo
     */
    private static int aumentarCosto(String opcion) {
        switch(opcion){
            case "Loteria":
                return (int) (costoLoteria*MULTIPLICADOR_COSTO);
            case "Espacio":
                return (int) (costoEspacio*MULTIPLICADOR_COSTO);
            case "Salud":
                return (int) (costoSalud*MULTIPLICADOR_COSTO);
        }
        return 0;
    }
}
