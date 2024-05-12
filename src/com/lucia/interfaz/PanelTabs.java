
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
                JPanel placeHolder = new JPanel();

            tabbedPane.addTab("Mercado", panelMercado);
            tabbedPane.addTab("placeHolder", placeHolder);

        add(tabbedPane, BorderLayout.CENTER);

    }
}