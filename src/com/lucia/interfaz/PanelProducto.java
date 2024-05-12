package com.lucia.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.lucia.producto.Producto;

public class PanelProducto extends JPanel{

    private JLabel nombreProductoLabel;
    private JLabel precioActualLabel;
    private JLabel cantDisponibleMercado;
    private JLabel cantDisponibleAlmacen;
    private JButton comprarBtn;
    private JButton venderBtn;

    public PanelProducto(Producto producto){ // ToDo: Cambiar placeholders
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setBackground(Color.PINK); // prueba

        Font fuente = new Font("Arial", Font.BOLD, 16);

        // Texto (Etiquetas)

            nombreProductoLabel = new JLabel(producto.getNombreProducto());
            precioActualLabel = new JLabel(String.valueOf(producto.getPrecio()));
            cantDisponibleMercado = new JLabel("[CantMercado]");
            cantDisponibleAlmacen = new JLabel("[CantAlmacen]");

            nombreProductoLabel.setFont(fuente);
            precioActualLabel.setFont(fuente);
            cantDisponibleMercado.setFont(fuente);
            cantDisponibleAlmacen.setFont(fuente);

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
        add(cantDisponibleMercado);
        add(Box.createHorizontalStrut(10));
        add(cantDisponibleAlmacen);
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
