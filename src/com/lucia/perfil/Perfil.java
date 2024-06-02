
package com.lucia.perfil;

import java.io.Serializable;

public class Perfil implements Serializable{
    /**
     * Nombre del perfil de la partida
     */
    private String nombrePerfil;
    /**
     * Dinero disponible para el jugador
     */
    private int fondos;
    /**
     * Cantidad de dinero ganado a lo largo de la partida
     */
    private int ganancias;
    /**
     * Cantidad de dinero gastado a lo largo de la partida
     */
    private int perdidas;
    /**
     * Cantidad de salud del jugador
     */
    private int salud;
    
    public final static int SALUD_MIN_PARTIDA = 1;
    /**
     * Años de la partida
     */
    private int años;
    /**
     * Almacen asociado al perfil
     */
    private Almacen almacen;
    /**
     * MErcado asociado al perfil
     */
    private Mercado mercado;
    
    // CONSTRUCTOR

    public Perfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
        this.fondos = 1500;
        this.ganancias = 0;
        this.perdidas = 0;
        this.salud = 100;
        this.años = 18;
        this.almacen = new Almacen();
        this.mercado = new Mercado();
    }
    
    // GETTERS

    public static int getSALUD_MIN_PARTIDA() {
        return SALUD_MIN_PARTIDA;
    }

    public String getNombrePerfil() {
        return nombrePerfil;
    }

    public int getFondos() {
        return fondos;
    }

    public int getGanancias() {
        return ganancias;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public int getSalud() {
        return salud;
    }

    public int getAños() {
        return años;
    }

    public Almacen getAlmacen() {
        return almacen;
    }

    public Mercado getMercado() {
        return mercado;
    }
    
    // SETTERS

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public void setFondos(int fondos) {
        this.fondos = fondos;
    }

    public void setGanancias(int ganancias) {
        this.ganancias = ganancias;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public void setAños(int años) {
        this.años = años;
    }

    public void setAlmacen(Almacen almacen) {
        this.almacen = almacen;
    }
    
    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }
}
