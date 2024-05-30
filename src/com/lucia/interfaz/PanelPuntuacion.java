package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import com.lucia.puntuacion.Puntuacion;

public class PanelPuntuacion extends JPanel{

    Font fuente = new Font("Arial", Font.PLAIN, 16);

    public PanelPuntuacion(Puntuacion puntuacion){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel(puntuacion.nombre);
        JLabel puntuacionLabel = new JLabel(String.valueOf(puntuacion.puntuacion));
        
        puntuacionLabel.setFont(fuente);

        add(nombreLabel);
        add(puntuacionLabel);
    }
}