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

           
        setContentPane(panel);
        setVisible(true);
    }

    public static void main(String[] args) { // Preuba
        SwingUtilities.invokeLater(() -> {
            new PanelCompraVenta();
        });
    }
}
