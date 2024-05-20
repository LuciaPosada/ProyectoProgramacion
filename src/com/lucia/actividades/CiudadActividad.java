package com.lucia.actividades;

public class CiudadActividad {

    private static int costoSalud = 100; // Costo Base

    public final static float MULTIPLICADOR_COSTO = 0.2f;

    public final static int CANTIDAD_AUMENTAR_SALUD = 20;

    /**
     * Aumenta la salud del jugador en 20
     * @param saludActual del perfil
     * @return la nueva cantidad de salud
     */
    public static int irHospital(int saludActual) {
        costoSalud = aumentarCosto();
        return saludActual+CANTIDAD_AUMENTAR_SALUD;
    }

    /**
     * Aumenta el costo financiero
     * @return el nuevo costo
     */
    private static int aumentarCosto() {
        return (int) (costoSalud*MULTIPLICADOR_COSTO);
    }

} 
