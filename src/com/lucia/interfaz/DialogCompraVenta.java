package com.lucia.interfaz;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DialogCompraVenta extends JDialog {

    private JButton cancelarBtn;
    private JButton aceptarBtn;
    private JSlider slider;
    private JTextField valorSeleccionadoTxt;

    public DialogCompraVenta(JFrame parent) {
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

                slider = new JSlider(JSlider.HORIZONTAL, 0, 100, 1); // ToDo: Cambiar maximo
                slider.setMajorTickSpacing(20);
                slider.setMinorTickSpacing(5);
                slider.setPaintTicks(true);
                slider.setPaintLabels(true);

                // Numero del Slider - JTextField

                valorSeleccionadoTxt = new JTextField(5);
                valorSeleccionadoTxt.setEditable(false);
                valorSeleccionadoTxt.setHorizontalAlignment(JTextField.CENTER);

                slider.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        int valorSeleccionado = slider.getValue();
                        valorSeleccionadoTxt.setText(Integer.toString(valorSeleccionado));
                    }
                });

                // JLabel

                JLabel cantidadDinero = new JLabel("[precio]");

            JPanel informacionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            informacionPanel.add(valorSeleccionadoTxt);
            informacionPanel.add(cantidadDinero);

            sliderPanel.add(slider, BorderLayout.CENTER);
            sliderPanel.add(informacionPanel, BorderLayout.SOUTH);

            // Panel Botones

            JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

            cancelarBtn = new JButton("Cancelar");
            aceptarBtn = new JButton("Aceptar");

            btnPanel.add(cancelarBtn);
            btnPanel.add(aceptarBtn);

        panel.add(sliderPanel);
        panel.add(btnPanel);

        setContentPane(panel);
        setVisible(true);
    }
}

