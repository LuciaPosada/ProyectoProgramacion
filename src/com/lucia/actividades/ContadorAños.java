
package com.lucia.actividades;

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
        
        final int SALUD_A_EMPEORAR_ENTRE_20_40_AÑOS = 10;
        final int SALUD_A_EMPEORAR_ENTRE_40_60_AÑOS = 20;
        final int SALUD_A_EMPEORAR_MAYOR_DE_60_AÑOS = 30;
        
        final int VEINTE_AÑOS = 20;
        final int CUARENTA_AÑOS = 40;
        final int SESENTA_AÑOS = 60;
        
        if(años>VEINTE_AÑOS&&años<CUARENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_ENTRE_20_40_AÑOS;
        }else if (años>=CUARENTA_AÑOS&&años<=SESENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_ENTRE_40_60_AÑOS;
        }else if(años>SESENTA_AÑOS){
            return salud - SALUD_A_EMPEORAR_MAYOR_DE_60_AÑOS;
        }else{ // menores de 20
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
}
