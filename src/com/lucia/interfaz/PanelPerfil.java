
package com.lucia.interfaz;

import java.awt.Component;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.BorderFactory;
import javax.swing.border.Border;

public class PanelPerfil extends JPanel {

    public PanelPerfil(Perfil perfil) {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Panel Contenedor

            JPanel panelContenedor = new JPanel();
            panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

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

                JLabel saludEtiqueta = new JLabel("[img] [num]");
                saludEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); 
                JLabel espacioEtiqueta = new JLabel("[img] [num]");
                espacioEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); 
                JLabel placeholderEtiqueta = new JLabel("[img] [num]");
                placeholderEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT);

                panelStats.add(saludEtiqueta);
                panelStats.add(espacioEtiqueta);
                panelStats.add(placeholderEtiqueta);
            
            panelContenedor.add(panelInfo);
            panelContenedor.add(Box.createVerticalStrut(10));
            panelContenedor.add(new JSeparator(JSeparator.HORIZONTAL)); 
            panelContenedor.add(Box.createVerticalStrut(10)); 
            panelContenedor.add(panelStats);

        // Panel Botones

            JPanel panelBtns = new PanelBotonesJuego();

        // Bordes

            Border borde1 = BorderFactory.createTitledBorder("Acciones");
            Border borde2 = BorderFactory.createTitledBorder("Informacion");
            
            panelContenedor.setBorder(borde2);
            panelBtns.setBorder(borde1);

        // Ajustar paneles

            Dimension maxDimension = new Dimension(Integer.MAX_VALUE, 50);
            panelContenedor.setMaximumSize(maxDimension); 
            panelBtns.setMaximumSize(maxDimension);

        // Añadir elementos al PanelPerfil

            add(Box.createVerticalGlue());
            add(panelContenedor);
            add(Box.createVerticalStrut(50));
            add(panelBtns);
            add(Box.createVerticalStrut(20));
    }

}
