
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
    
    /**
     * Obtiene la puntuación almacenada con la clave especificada.
     * @param clave Clave de la puntuación a recuperar
     * @return La puntuación asociada con la clave, o null si no existe.
     */
    public static Puntuacion getPuntuacion(String clave) {
        return puntuaciones.get(clave);
    }
}
