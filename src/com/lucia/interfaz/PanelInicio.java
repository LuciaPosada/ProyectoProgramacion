
package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Box; 

import java.awt.Color;

public class PanelInicio extends JPanel {

    private JButton btnNuevaPrt;
    private JButton btnCargarPrt;
    private JButton btnPuntuacion;

    public PanelInicio() {
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.BLUE); // Prueba

        btnNuevaPrt = new JButton("Nueva Partida");
        btnCargarPrt = new JButton("Cargar Partida");
        btnPuntuacion = new JButton("Puntuaciones");

        add(Box.createHorizontalGlue());
        add(btnNuevaPrt);
        add(Box.createHorizontalStrut(10)); 
        add(btnCargarPrt);
        add(Box.createHorizontalStrut(10)); 
        add(btnPuntuacion);
        add(Box.createHorizontalGlue());
    }

    public JButton getBtnNuevaPrt() {
        return btnNuevaPrt;
    }

    public JButton getBtnCargarPrt() {
        return btnCargarPrt;
    }

    public JButton getBtnPuntuacion() {
        return btnPuntuacion;
    }
}
