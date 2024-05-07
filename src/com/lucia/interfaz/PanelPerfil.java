
package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

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

	// Panel Botones

    }

}
