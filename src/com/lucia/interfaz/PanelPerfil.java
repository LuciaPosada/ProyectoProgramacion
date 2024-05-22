
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

import com.lucia.perfil.Perfil;

public class PanelPerfil extends JPanel {
    private Perfil perfil;
    private JLabel nombreEtiqueta;
    private JLabel añosEtiqueta;
    private JLabel saludEtiqueta;
    private JLabel espacioEtiqueta;
    private JLabel placeholderEtiqueta;

    public PanelPerfil(Perfil perfil) {
        this.perfil = perfil;
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        if (perfil == null) {
            throw new IllegalArgumentException("Perfil null"); /// Debug
        }

        // Panel Contenedor

            JPanel panelContenedor = new JPanel();
            panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

            // Panel de Informacion del Jugador

                JPanel panelInfo = new JPanel();
                panelInfo.setLayout(new BoxLayout(panelInfo, BoxLayout.X_AXIS));

                nombreEtiqueta = new JLabel(perfil.getNombrePerfil());
                añosEtiqueta = new JLabel("Años: "+perfil.getAños());

                panelInfo.add(Box.createHorizontalGlue());
                panelInfo.add(nombreEtiqueta);
                panelInfo.add(Box.createHorizontalStrut(10));
                panelInfo.add(añosEtiqueta);
                panelInfo.add(Box.createHorizontalGlue());

            // Panel de Estadisticas del Jugador

                JPanel panelStats = new JPanel();
                panelStats.setLayout(new BoxLayout(panelStats, BoxLayout.Y_AXIS));

                saludEtiqueta = new JLabel("[img] "+perfil.getSalud());
                    saludEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); 
                espacioEtiqueta = new JLabel("[img] "+perfil.getFondos());
                    espacioEtiqueta.setAlignmentX(Component.CENTER_ALIGNMENT); 
                placeholderEtiqueta = new JLabel("[img] "+perfil.getAlmacen().getEspacioAlmacen());
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

            JPanel panelBtns = new PanelBotonesJuego(this);

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

    public Perfil getPerfil() {
        return perfil;
    }

    /**
     * Actualiza la información mostrada en el panel con los valores actuales del perfil
     */
    public void actualizarInformacion() {
        añosEtiqueta.setText("Años: " + perfil.getAños());
        saludEtiqueta.setText("[img] " + perfil.getSalud());
        // Faltan etiquetas
    }

}