package com.lucia.interfaz;

import javax.swing.JPanel;

import com.lucia.perfil.Perfil;

import java.awt.BorderLayout;
import java.awt.Color;

public class PanelJuego extends JPanel {

    private Perfil perfil;
    private PanelPerfil panelPerfil;

    public PanelJuego() {
        setLayout(new BorderLayout());

        panelPerfil = new PanelPerfil(perfil);
        PanelTabs panelTabs = new PanelTabs();

        add(panelPerfil, BorderLayout.WEST);
        add(panelTabs, BorderLayout.CENTER);
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }

    private void actualizarPanelPerfil() {
        if (panelPerfil != null) {
            remove(panelPerfil);
        }
        panelPerfil = new PanelPerfil(perfil);
        add(panelPerfil);
        revalidate();
        repaint();
    }
}
