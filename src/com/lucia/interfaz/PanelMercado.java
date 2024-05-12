
package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class PanelMercado extends JScrollPane{

    PanelProducto pnlProducto;
    JPanel panelContenedor;

    Mercado mercado = new Mercado();

    public PanelMercado(){

        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

	for (Producto producto : mercado.getProductosEnVenta().values()) {
            panelContenedor.add(new PanelProducto(producto));
        }

        this.setViewportView(panelContenedor);
    }

}
