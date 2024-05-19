package com.lucia.interfaz;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCiudad extends JPanel{

    public PanelCiudad() {
        setLayout(new GridLayout(3,1));

        JButton hospital = new JButton("Ir al Hospital");
        JButton loteria = new JButton("Comprar un billete de loteria");
        JButton almacenes = new JButton("Aumentar espacio de almacen");

        hospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /* Ciudad.comprarSalud(perfil); */ //ToDo: Añadir metodo + clase
            }
        });

        add(hospital);
        add(loteria);
        add(almacenes);

    }
    
}
