
package com.lucia.interfaz;

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

            panelInfo.add(nombreEtiqueta);
            panelInfo.add(añosEtiqueta);

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

	    JButton btnVolver = new JButton("Volver al Inicio");

	    JButton btnAvanzar = new JButton("Avanzar Año"); // Pendiente de accion

	    panelBtns.add(btnVolver);
	    panelBtns.add(btnAvanzar);

        // Añadir elementos al PanelPerfil

        add(panelInfo);
        add(new JSeparator(JSeparator.HORIZONTAL));
        add(panelStats);
        add(panelBtns);

    }

}
