package com.lucia.interfaz;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.lucia.perfil.Almacen;
import com.lucia.perfil.Perfil;
import com.lucia.producto.Producto;

public class PanelAlmacen extends JScrollPane{

    JPanel panelContenedor;
    Almacen almacen;

    public PanelAlmacen(Perfil perfil) {
        this.almacen = perfil.getAlmacen();
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.Y_AXIS));

        for (Producto producto : almacen.getProductosAlmacenados().values()) { // Crea paneles para los productos
            PanelProducto panelProducto = new PanelProducto(producto,"venta",perfil);
            panelProducto.setAlignmentX(LEFT_ALIGNMENT);
            panelContenedor.add(panelProducto);
        }
        this.setViewportView(panelContenedor);
    }
}
