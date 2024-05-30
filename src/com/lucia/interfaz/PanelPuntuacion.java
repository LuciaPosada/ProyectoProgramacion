package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.lucia.puntuacion.Puntuacion;

public class PanelPuntuacion extends JPanel{

    public PanelPuntuacion(Puntuacion puntuacion){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel(puntuacion.nombre);
        JLabel puntuacionLabel = new JLabel(String.valueOf(puntuacion.puntuacion));

        add(nombreLabel);
        add(puntuacionLabel);
    }
}