package com.lucia.interfaz;

import java.util.ArrayList;

import javax.swing.*;

import com.lucia.puntuacion.Puntuacion;
import com.lucia.puntuacion.Puntuaciones;

public class PanelPuntuaciones extends JScrollPane {

    JPanel panelContenedor;

    public PanelPuntuaciones() {
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        ArrayList<Puntuacion> puntuaciones = Puntuaciones.obtenerTodasLasPuntuaciones();

        for (Puntuacion puntuacion : puntuaciones) { // Crea paneles para las puntuaciones
            PanelPuntuacion panelPuntuacion = new PanelPuntuacion(puntuacion);
            panelContenedor.add(panelPuntuacion);
        }

        this.setViewportView(panelContenedor);
    }

}
