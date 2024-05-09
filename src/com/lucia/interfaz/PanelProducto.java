package com.lucia.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelProducto extends JPanel{

    private JLabel nombreProductoLabel;
    private JLabel precioActualLabel;
    private JButton comprarBtn;
    private JButton venderBtn;

    public PanelProducto(/*producto*/){ // ToDo: Cambiar placeholders
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.PINK); // prueba

	Font fuente = new Font("Arial", Font.BOLD, 16);

        // Texto (Etiquetas)

            nombreProductoLabel = new JLabel("[Producto]");
            precioActualLabel = new JLabel("[Precio]");

            nombreProductoLabel.setFont(fuente);
            precioActualLabel.setFont(fuente);

        // Botones
        
            comprarBtn = new JButton("Comprar");
            venderBtn = new JButton("Vender");

        // Añadir elementos al panel
        
        add(nombreProductoLabel);
        add(Box.createHorizontalStrut(20));
        add(precioActualLabel);
        add(Box.createHorizontalStrut(10));
        add(comprarBtn);
        add(Box.createHorizontalStrut(5));
        add(venderBtn);
    }

}