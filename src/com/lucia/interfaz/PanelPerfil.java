
package com.lucia.interfaz;

import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;


public class PanelPerfil extends JPanel {

    public PanelPerfil() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel de Informacion del Jugador

            JPanel panelInfo = new JPanel();
            panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));

            JLabel nombreEtiqueta = new JLabel("[nombre]");
            JLabel añosEtiqueta = new JLabel("Años: [num]");

            panelInfo.add(Box.createHorizontalGlue()); 
            panelInfo.add(nombreEtiqueta);
            panelInfo.add(Box.createHorizontalStrut(10)); 
            panelInfo.add(añosEtiqueta);
            panelInfo.add(Box.createHorizontalGlue()); 

        // Panel de Estadisticas del Jugador

            JPanel panelStats = new JPanel();
            panelStats.setLayout(new BoxLayout(panelStats, BoxLayout.Y_AXIS));

            JLabel saludEtiqueta = new JLabel("[img] Salud: [num]");
            JLabel espacioEtiqueta = new JLabel("[img] Espacio: [num]");
            JLabel placeholderEtiqueta = new JLabel("[img] Placeholder: [num]"); // Placeholder

            panelStats.add(saludEtiqueta);
            panelStats.add(espacioEtiqueta);
            panelStats.add(placeholderEtiqueta);

	// Panel Botones

	    JPanel panelBtns = new JPanel(); // Pendiente de accion
            panelBtns.setLayout(new BoxLayout(panelBtns, BoxLayout.X_AXIS));

	    JButton btnVolver = new JButton("Volver al Inicio"); // Pendiente de accion

	    JButton btnAvanzar = new JButton("Avanzar Año"); // Pendiente de accion

	    panelBtns.add(Box.createHorizontalGlue()); 
            panelBtns.add(btnVolver);
            panelBtns.add(Box.createHorizontalStrut(10)); 
            panelBtns.add(btnAvanzar);
            panelBtns.add(Box.createHorizontalGlue());

        // Ajustar paneles

        Dimension maxDimension = new Dimension(Integer.MAX_VALUE, 50); 

        panelInfo.setMaximumSize(maxDimension);
        panelStats.setMaximumSize(maxDimension);
        panelBtns.setMaximumSize(maxDimension);

        panelInfo.setAlignmentX(CENTER_ALIGNMENT);
        panelStats.setAlignmentX(CENTER_ALIGNMENT);
        panelBtns.setAlignmentX(CENTER_ALIGNMENT);

        // Añadir elementos al PanelPerfil

        add(Box.createVerticalGlue());
        add(panelInfo);
        add(Box.createVerticalStrut(10)); 
        add(new JSeparator(JSeparator.HORIZONTAL));
        add(Box.createVerticalStrut(10)); 
        add(panelStats);
        add(Box.createVerticalStrut(10)); 
        add(panelBtns);
        add(Box.createVerticalGlue());

    }

}
