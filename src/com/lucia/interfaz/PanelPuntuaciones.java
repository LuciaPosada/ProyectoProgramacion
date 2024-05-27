package com.lucia.interfaz;

import com.lucia.producto.Producto;

import javax.swing.*;

public class PanelPuntuaciones extends JScrollPane {

    JPanel panelContenedor;

    public PanelPuntuaciones() {
        panelContenedor = new JPanel();
        panelContenedor.setLayout(new BoxLayout(panelContenedor, BoxLayout.X_AXIS));

    }

}
