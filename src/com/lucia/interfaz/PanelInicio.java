
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


        // Estetica de los botones
            Font buttonFont = new Font("Arial", Font.PLAIN, 17); 

            btnNuevaPrt.setFont(buttonFont);
            btnCargarPrt.setFont(buttonFont);
            btnPuntuacion.setFont(buttonFont);

            btnNuevaPrt.setPreferredSize(new java.awt.Dimension(150, 60));
            btnCargarPrt.setPreferredSize(new java.awt.Dimension(150, 60));
            btnPuntuacion.setPreferredSize(new java.awt.Dimension(150, 60));

        add(Box.createHorizontalGlue());
        add(btnNuevaPrt);
        add(Box.createHorizontalStrut(25)); 
        add(btnCargarPrt);
        add(Box.createHorizontalStrut(25)); 
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
