package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lucia.actividades.Mercado;
import com.lucia.producto.Producto;

public class PanelMercado extends JScrollPane {

    JPanel panelContenedor;

    Mercado mercado = new Mercado();

    public PanelMercado() {
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        for (Producto producto : mercado.getProductosEnVenta().values()) { // Crea paneles para los productos
            PanelProducto panelProducto = new PanelProducto(producto);
            panelProducto.setAlignmentX(LEFT_ALIGNMENT);
            panelContenedor.add(panelProducto);
        }
        this.setViewportView(panelContenedor);
    }
}
