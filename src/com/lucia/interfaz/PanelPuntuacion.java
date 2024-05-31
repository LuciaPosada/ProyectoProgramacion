package com.lucia.interfaz;

import javax.swing.*;
import java.awt.*;

import com.lucia.puntuacion.Puntuacion;

public class PanelPuntuacion extends JPanel{

    Font fuente = new Font("Arial", Font.PLAIN, 15);
    Font fuent2 = new Font("Arial", Font.BOLD, 17);

    public PanelPuntuacion(Puntuacion puntuacion){
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel nombreLabel = new JLabel(puntuacion.nombre);
        JLabel puntuacionLabel = new JLabel(String.valueOf(puntuacion.puntuacion));

        nombreLabel.setFont(fuent2);
        puntuacionLabel.setFont(fuente);

        add(nombreLabel);
        add(puntuacionLabel);

        // Borde

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));
    }
}