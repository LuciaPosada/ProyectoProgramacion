package com.lucia.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
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

        // Borde

        setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.DARK_GRAY),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)));

        // Añadir elementos al panel
        
        add(nombreProductoLabel);
        add(Box.createHorizontalStrut(20));
        add(precioActualLabel);
        add(Box.createHorizontalStrut(10));
        add(comprarBtn);
        add(Box.createHorizontalStrut(5));
        add(venderBtn);
    }

    /**
     * Metodo para actualizar la etiqueta [precio] del producto
     * @param nuevoPrecio el nuevo precio por el que se va cambiar el anterior
     * @param cambioPrecio dicta si se a producido un aumento/disminucion o nada
     */
    void setPrecioLabel(String nuevoPrecio,String cambioPrecio) { // ToDo: Añadir manera de dircernir si el precio a aumentado o disminuido
        final String AUMENTO = "aumento";
        final String DISMINUCION = "disminucion";
        final String IGUAL = "igual";
        
        precioActualLabel.setText(nuevoPrecio);

        switch (cambioPrecio) {
            case IGUAL:
                precioActualLabel.setForeground(Color.BLACK);
                break;
            case AUMENTO:
                precioActualLabel.setForeground(Color.GREEN);
                break;
            case DISMINUCION:
                precioActualLabel.setForeground(Color.RED);
                break;
        }
    }

}