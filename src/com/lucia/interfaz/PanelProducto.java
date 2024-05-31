package com.lucia.interfaz;

import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.lucia.actividades.Mercado;
import com.lucia.producto.Producto;

public class PanelProducto extends JPanel{

    private JLabel nombreProductoLabel;
    private JLabel precioActualLabel;
    private JLabel cantDisponibleMercado;
    private JLabel cantDisponibleAlmacen;
    private JButton comprarBtn;
    private JButton venderBtn;

    private Producto producto;

    private JFrame parentFrame; // Para pasarselo al panel CompraVenta

    public PanelProducto(Producto producto){ // ToDo: Cambiar placeholders
        this.producto = producto;
        this.parentFrame = parentFrame;
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

        Font fuente = new Font("Arial", Font.BOLD, 16);

        // Texto (Etiquetas)

            nombreProductoLabel = new JLabel(producto.getNombreProducto());
            precioActualLabel = new JLabel(String.valueOf(producto.getPrecio()));
            cantDisponibleMercado = new JLabel("[CantM]");
            cantDisponibleAlmacen = new JLabel("[CantA]");

            nombreProductoLabel.setFont(fuente);
            precioActualLabel.setFont(fuente);
            cantDisponibleMercado.setFont(fuente);
            cantDisponibleAlmacen.setFont(fuente);

        // Botones
        
            comprarBtn = new JButton("Comprar");
            venderBtn = new JButton("Vender");


            comprarBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarDialogCompraVenta(producto);
                }
            });

            venderBtn.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    mostrarDialogCompraVenta(producto);
                }
            });

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

        // Oberver
        Mercado.agregarObservador(this);
    }

    /**
     * Metodo para actualizar la etiqueta [precio] del producto
     * @param nuevoPrecio el nuevo precio por el que se va cambiar el anterior
     * @param cambioPrecio dicta si se a producido un aumento/disminucion o nada
     */
    void setPrecioLabel(String nuevoPrecio,String cambioPrecio) {
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

    /**
     * Actualiza el precio del producto en la interfaz en base a el aumento o disminucion de este
     */
    public void actualizarPrecio() {
        int nuevoPrecio = producto.getPrecio();
        int precioAnterior = Integer.parseInt(precioActualLabel.getText());
        String cambioPrecio;

        if (nuevoPrecio > precioAnterior) {
            cambioPrecio = "aumento";
        } else if (nuevoPrecio < precioAnterior) {
            cambioPrecio = "disminucion";
        } else {
            cambioPrecio = "igual";
        }

        setPrecioLabel(String.valueOf(nuevoPrecio), cambioPrecio);
    }

    /**
     * Muestra el dialogo de compra/venta
     */
    private void mostrarDialogCompraVenta(Producto producto) {
        DialogCompraVenta dialog = new DialogCompraVenta(parentFrame,producto);
        dialog.setVisible(true);
    }

}
