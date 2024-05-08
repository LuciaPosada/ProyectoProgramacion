
package com.lucia.puntuacion;

import java.util.HashMap;

public class Puntuaciones {
    
    public static HashMap<String,Puntuacion> puntuaciones = new HashMap<>();
    
    /**
     * Crea una puntuacion con los parametros especificados
     * @param nombre variable para el nuevo objecto
     * @param puntuacion variable para el nuevo objecto
     * @return la nueva puntuacion recien creada
     */
    public static Puntuacion crearNuevaPuntuacion(String nombre,int puntuacion){
        Puntuacion puntuacionNuevo = new Puntuacion(puntuacion,nombre); 
        puntuaciones.put("",puntuacionNuevo); // TODO: Metodo para generar claves en orden
        return puntuacionNuevo; 
    }
    
}
