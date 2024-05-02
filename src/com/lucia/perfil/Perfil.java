
package com.lucia.perfil;

public class Perfil {
    
    private String nombrePerfil;
    
    private int fondos;
    
    private int salud;
    
    public final static int SALUD_MIN_PARTIDA = 1;
    
    private int años;
    
    private Almacen almacen;
    
    // CONSTRUCTOR

    public Perfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
        this.fondos = 500;
        this.salud = 100;
        this.años = 18;
        this.almacen = new Almacen();
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

    public int getSalud() {
        return salud;
    }

    public int getAños() {
        return años;
    }

    public Almacen getAlmacen() {
        return almacen;
    }
    
    // SETTERS

    public void setNombrePerfil(String nombrePerfil) {
        this.nombrePerfil = nombrePerfil;
    }

    public void setFondos(int fondos) {
        this.fondos = fondos;
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
    
}
