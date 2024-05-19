package com.lucia.interfaz;

import javax.swing.JPanel;
import com.lucia.perfil.Perfil;
import java.awt.BorderLayout;

public class PanelJuego extends JPanel {

    private Perfil perfil;
    private PanelPerfil panelPerfil;

    public PanelJuego() {
        setLayout(new BorderLayout());

        PanelTabs panelTabs = new PanelTabs();
        add(panelTabs, BorderLayout.CENTER);
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
        actualizarPanelPerfil();
    }

    private void actualizarPanelPerfil() {
        if (panelPerfil != null) {
            remove(panelPerfil);
        }
        panelPerfil = new PanelPerfil(perfil);
        add(panelPerfil, BorderLayout.WEST);
        revalidate();
        repaint();
    }
}