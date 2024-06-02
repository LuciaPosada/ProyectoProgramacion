
package com.lucia.actividades;

import com.lucia.interfaz.VentanaPrincipal;
import com.lucia.perfil.Perfil;
import com.lucia.puntuacion.Puntuacion;
import com.lucia.puntuacion.Puntuaciones;

public class ContadorAños {
    
    /**
     * Metodo que suma 1 año a los que tiene el pefil de la partida
     * @param años del perfil
     * @return años 
     */
    public static int sumarAño(int años){
        return años+1;  
    }
    
    /**
     * Metodo que reduce la salud en base a los años del perfil
     * @param salud del perfil
     * @param años del perfil
     * @return salud con la cantidad correspondiente reducida
     */
    public static int empeorarSalud(int salud,int años){
        
        final int SALUD_A_EMPEORAR_ENTRE_30_50_AÑOS = 10;
        final int SALUD_A_EMPEORAR_ENTRE_50_70_AÑOS = 20;
        final int SALUD_A_EMPEORAR_MAYOR_DE_70_AÑOS = 30;
        
        final int TREINTA_AÑOS = 30;
        final int CINCUENTA_AÑOS = 50;
        final int SETENTA_AÑOS = 70;
        
        if(años>TREINTA_AÑOS&&años<CINCUENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_ENTRE_30_50_AÑOS;
        }else if (años>=CINCUENTA_AÑOS&&años<=SETENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_ENTRE_50_70_AÑOS;
        }else if(años>SETENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_MAYOR_DE_70_AÑOS;
        }else{ // menores de 30
            return salud;
        }  
    } 
    
    /**
     * Comprueba si la salud es igual o menor que cero
     * @param salud variable que se va a evauluar
     * @return true si se a la salud a llegado a cero o menos | false si la salud esta por encima de 0
     */
    public static boolean comprobarLimiteSalud(int salud) {
        return salud <= 0;
    }

   /**
    * Calcula la puntuación final basandose en los años, ganancias y perdidas
    * @param años el número de años
    * @param ganancias las ganancias obtenidas
    * @param perdidas las pérdidas incurridas
    * @return la puntuación final calculada como años multiplicados por la diferencia entre ganancias y pérdidas
    */
    public static int calcularPuntuacionFinal(int años,int ganancias, int perdidas) {
        return años*(ganancias-perdidas);
    }

    /**
     * Crea la puntuacion final y elimina la partida
     * @param perfil el perfil de la partida a finalizar
     */
    public static void finalizarPartida(Perfil perfil){
        Puntuacion puntuacion = new Puntuacion( calcularPuntuacionFinal(perfil.getAños(),perfil.getGanancias(),perfil.getPerdidas()), perfil.getNombrePerfil());
        Puntuaciones.crearPuntuacion(puntuacion);
        VentanaPrincipal.eliminarPerfil(perfil.getNombrePerfil()); 
    }
}
