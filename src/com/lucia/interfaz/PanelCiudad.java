package com.lucia.interfaz;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;

public class PanelCiudad extends JPanel{

    public PanelCiudad() {
        setLayout(new GridLayout(3,1));

        JButton hospital = new JButton("Ir al Hospital");
        JButton loteria = new JButton("Comprar un billete de loteria");
        JButton almacenes = new JButton("Aumentar espacio de almacen");

        add(hospital);
        add(loteria);
        add(almacenes);

    }
    
}
