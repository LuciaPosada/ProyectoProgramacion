
package com.lucia.interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;


public class PanelBotonesJuego extends JPanel {

    public PanelBotonesJuego() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JButton btnVolver = new JButton("Volver al Inicio");
        JButton btnAvanzar = new JButton("Avanzar Año");

        configurarBoton(btnVolver);
        configurarBoton(btnAvanzar);

        add(Box.createVerticalGlue());
        add(btnVolver);
        add(Box.createVerticalStrut(10));
        add(btnAvanzar);
        add(Box.createVerticalGlue());
    }

    private void configurarBoton(JButton button) {
        button.setAlignmentX(CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(Integer.MAX_VALUE, button.getPreferredSize().height));

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (button.getText().equals("Volver al Inicio")) {
                    VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) getTopLevelAncestor();
                    ventanaPrincipal.mostrarPanelInicio();
                } else if (button.getText().equals("Avanzar Año")) {
                    // Aqui acciones Avanzar Año
                }
            }
        });
    }
}