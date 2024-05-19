package com.lucia.interfaz;

import javax.swing.JPanel;
import com.lucia.perfil.Perfil;
import java.awt.BorderLayout;
import java.awt.Color;

public class PanelJuego extends JPanel {

    private Perfil perfil;

    public PanelJuego() {
        setLayout(new BorderLayout());

        PanelPerfil panelPerfil = new PanelPerfil(perfil);
        PanelTabs panelTabs = new PanelTabs();

        panelPerfil.setBackground(Color.BLUE);
        panelTabs.setBackground(Color.ORANGE);

        add(panelPerfil, BorderLayout.WEST);
        add(panelTabs, BorderLayout.CENTER);
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
