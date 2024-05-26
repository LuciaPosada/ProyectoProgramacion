package com.lucia.interfaz;

import com.lucia.actividades.CompraVenta;
import com.lucia.producto.Producto;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogCompraVenta extends JDialog {

    private JButton cancelarBtn;
    private JButton aceptarBtn;
    private JSlider slider;
    private JTextField cantidadSeleccionadaTxt;
    private JLabel cantidadDinero;

    public DialogCompraVenta(JFrame parent, Producto producto) {
        super(parent, true);
        setTitle("Comprar/Vender"); // Pendiente de revision
        setSize(400, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Panel Slider

        JPanel sliderPanel = new JPanel(new BorderLayout());

        // Slider

        slider = new JSlider(JSlider.HORIZONTAL, 1, producto.getCantidad(), 1); // ToDo: Arreglar que el maximo no se vea
        slider.setPaintTicks(false);
        slider.setPaintLabels(false);

        // Numero del Slider - JTextField

        cantidadSeleccionadaTxt = new JTextField(5);
        cantidadSeleccionadaTxt.setEditable(false);
        cantidadSeleccionadaTxt.setHorizontalAlignment(JTextField.CENTER);

        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                actualizarCantidadSeleccionadaTxt(slider.getValue());
                actualizarCantidadDinero(slider.getValue(), producto.getPrecio());
            }
        });

        // JLabel

        cantidadDinero = new JLabel(CompraVenta.calcularPrecioTotal(1, producto.getPrecio()) + " €");

        JPanel informacionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        informacionPanel.add(cantidadSeleccionadaTxt);
        informacionPanel.add(cantidadDinero);

        sliderPanel.add(slider, BorderLayout.CENTER);
        sliderPanel.add(informacionPanel, BorderLayout.SOUTH);

        // Panel Botones

        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        cancelarBtn = new JButton("Cancelar");
        aceptarBtn = new JButton("Aceptar");

        cancelarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        aceptarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btnPanel.add(cancelarBtn);
        btnPanel.add(aceptarBtn);

        panel.add(sliderPanel);
        panel.add(btnPanel);

        setContentPane(panel);
        setVisible(true);
    }

    private void actualizarCantidadSeleccionadaTxt(int cantidad) {
        cantidadSeleccionadaTxt.setText(Integer.toString(cantidad));
    }

    private void actualizarCantidadDinero(int cantidad, int precio) {
        cantidadDinero.setText(CompraVenta.calcularPrecioTotal(cantidad, precio) + " €");
    }
}
