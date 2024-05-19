package com.lucia.interfaz;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogPedirNombre extends JDialog{ // ToDo: Mejorar la disposicion del panel
    
    private String nombrePartida;
    private JTextField nombreTextField;
    private JButton confirmarBtn;
    private boolean confirmacion;

    public DialogPedirNombre(JFrame parent) {
        super(parent, "Introduzca el nombre de la partida", true);
        setSize(300, 150);
        setLocationRelativeTo(parent);

        nombrePartida = "";
        confirmacion = false;

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Nombre de la partida:");
        nombreTextField = new JTextField(15);
        confirmarBtn = new JButton("Confirmar");

        confirmarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombrePartida = textField.getText().trim();
                if (!nombrePartida.isEmpty()) {
                    confirmacion = true;
                    dispose();
                }
            }
        });

        panel.add(label);
        panel.add(nombreTextField);
        panel.add(confirmarBtn);

        add(panel, BorderLayout.CENTER);
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

}
