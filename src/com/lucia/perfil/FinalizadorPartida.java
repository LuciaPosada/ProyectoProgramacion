package com.lucia.perfil;

public class FinalizadorPartida {

    /**
     * Comprueba si el perfil tiene suficiente salid para continuar la partida
     * @param salud variabla a comprobar
     * @return true en caso de que pueda continuar y false en caso de que no
     */
    public static boolean comprobarSaludSuficiente (int salud) {
        if(salud<=0){
            return false;
        }else{
            return true;
        }
    }


}
