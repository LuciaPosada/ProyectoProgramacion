package com.lucia.interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.lucia.perfil.Perfil;

public class PanelTabs extends JPanel {

    private Perfil perfil;
    private PanelPerfil panelPerfil;
    private JTabbedPane tabbedPane;

    public PanelTabs(Perfil perfil, PanelPerfil panelPerfil) {
        this.perfil = perfil;
        this.panelPerfil = panelPerfil;
        setLayout(new BorderLayout());
        iniciarTabs();
    }

    private void iniciarTabs() {
        tabbedPane = new JTabbedPane();

        // Pestañas

        PanelMercado panelMercado = new PanelMercado(perfil);
        PanelAlmacen panelAlmacen = new PanelAlmacen(perfil);
        PanelCiudad panelCiudad = new PanelCiudad(perfil, panelPerfil);

        tabbedPane.addTab("Mercado", panelMercado);
        tabbedPane.addTab("Almacen", panelAlmacen);
        tabbedPane.addTab("Ciudad", panelCiudad);

        add(tabbedPane, BorderLayout.CENTER);
    }
}
