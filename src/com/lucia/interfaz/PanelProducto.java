package com.lucia.interfaz;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.lucia.actividades.MercadoActividad;
import com.lucia.perfil.Perfil;
import com.lucia.producto.Producto;

public class PanelProducto extends JPanel{

    private JLabel nombreProductoLabel;
    private JLabel precioActualLabel;
    private JLabel monedaLabel;
    private JLabel unidadLabel;
    private JLabel cantDisponibleLabel;
    private JButton negocioBtn;
    private String opcion;

    private Producto producto;
    private Perfil perfil;

    private JFrame parentFrame;

    public PanelProducto(Producto producto, String opcion, Perfil perfil) {
        this.producto = producto;
        this.opcion = opcion;
        this.perfil = perfil;

        setLayout(new GridLayout(1, 5, 10, 10));
        Font fuente = new Font("Arial", Font.BOLD, 16);

	// Texto (Etiquetas)

        nombreProductoLabel = new JLabel(producto.getNombreProducto());
        precioActualLabel = new JLabel(String.valueOf(producto.getPrecio()));
        monedaLabel = new JLabel("€");
        unidadLabel = new JLabel("Ud.");
        cantDisponibleLabel = new JLabel(String.valueOf(producto.getCantidad()));

        nombreProductoLabel.setFont(fuente);
        precioActualLabel.setFont(fuente);
        monedaLabel.setFont(fuente);
        unidadLabel.setFont(fuente);
        cantDisponibleLabel.setFont(fuente);

	// Boton

        negocioBtn = new JButton("C/V");
        negocioBtn.addActionListener(new ActionListener() {
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
        add(precioActualLabel);
        add(monedaLabel);
        add(unidadLabel);
        add(cantDisponibleLabel);
        add(negocioBtn);

        MercadoActividad.agregarObservador(this);
    }

    void setPrecioLabel(String nuevoPrecio, String cambioPrecio) {
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

    public void actualizarCantidad() {
        cantDisponibleLabel.setText(String.valueOf(producto.getCantidad()));
    }

    /**
     * Muestra el dialogo de compra/venta
     */
    private void mostrarDialogCompraVenta(Producto producto) {
        if (producto.getCantidad() == 0) {
            JOptionPane.showMessageDialog(this, "No hay unidades disponibles para este producto.", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            DialogCompraVenta dialog = new DialogCompraVenta(parentFrame,producto,opcion,perfil);
            dialog.setVisible(true);
        }
    }
}
