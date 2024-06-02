package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import com.lucia.perfil.Mercado;
import com.lucia.perfil.Perfil;
import com.lucia.producto.Producto;

public class PanelMercado extends JScrollPane {

    JPanel panelContenedor;
    Mercado mercado;

    public PanelMercado(Perfil perfil) {
        this.mercado = perfil.getMercado();
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        for (Producto producto : mercado.getProductosEnVenta().values()) {
            PanelProducto panelProducto = new PanelProducto(producto,"compra",perfil);
            panelProducto.setAlignmentX(LEFT_ALIGNMENT);
            panelContenedor.add(panelProducto);
        }
        this.setViewportView(panelContenedor);
    }
}
