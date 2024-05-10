
package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMercado extends JScrollPane{

    PanelProducto pnlProducto;
    JPanel panelContenedor;

    public PanelMercado(){

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        for (int i = 0; i < 5; i++) {
            panelContenedor.add(new PanelProducto());
        }

        this.setViewportView(panelContenedor);
    }

}
