package com.lucia.interfaz;

import javax.swing.*;

public class PanelCompraVenta extends JDialog {

    private JSlider slider;

    public PanelCompraVenta() { 
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

		sliderPanel.add(slider, BorderLayout.CENTER);

                // JLabel

                JLabel cantidadDinero = new JLabel("[precio]");

	panel.add(sliderPanel);
           
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) { // Prueba
        SwingUtilities.invokeLater(() -> {
            new PanelCompraVenta();
        });
    }
}
