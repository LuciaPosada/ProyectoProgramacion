
package com.lucia.interfaz;

import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class PanelTabs extends JPanel {

    public PanelTabs() {
        setLayout(new BorderLayout());

        // TabbedPane

            JTabbedPane tabbedPane = new JTabbedPane();

            // Pestañas

                PanelMercado panelMercado = new PanelMercado();
                PanelCiudad panelCiudad = new PanelCiudad();
                JPanel placeholder = new JPanel();

            tabbedPane.addTab("Mercado", panelMercado);
            tabbedPane.addTab("Ciudad", panelCiudad);
            tabbedPane.addTab("Placeholder", placeholder);

        add(tabbedPane, BorderLayout.CENTER);

    }
}