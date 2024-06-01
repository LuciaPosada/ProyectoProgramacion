
package com.lucia.interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.lucia.perfil.Perfil;

public class PanelTabs extends JPanel {

    public PanelTabs(Perfil perfil,PanelPerfil panelPerfil) {
        setLayout(new BorderLayout());

        // TabbedPane

            JTabbedPane tabbedPane = new JTabbedPane();

            // Pestañas

                PanelMercado panelMercado = new PanelMercado();
                PanelAlmacen panelAlmacen = new PanelAlmacen();
                PanelCiudad panelCiudad = new PanelCiudad(perfil,panelPerfil);

            tabbedPane.addTab("Mercado", panelMercado);
            tabbedPane.addTab("Almacen",panelAlmacen);
            tabbedPane.addTab("Ciudad", panelCiudad);

        add(tabbedPane, BorderLayout.CENTER);

    }
}