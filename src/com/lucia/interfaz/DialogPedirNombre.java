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
import javax.swing.BoxLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;

public class DialogPedirNombre extends JDialog {

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
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel label = new JLabel("Nombre de la partida:");
        nombreTextField = new JTextField(15);
        confirmarBtn = new JButton("Confirmar");

        label.setAlignmentX(CENTER_ALIGNMENT);
        nombreTextField.setAlignmentX(CENTER_ALIGNMENT);
        confirmarBtn.setAlignmentX(CENTER_ALIGNMENT);

        confirmarBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombrePartida = nombreTextField.getText().trim();
                if (!nombrePartida.isEmpty()) {
                    confirmacion = true;
                    dispose();
                }
            }
        });

        panel.add(label);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(nombreTextField);
        panel.add(Box.createVerticalStrut(10)); 
        panel.add(confirmarBtn);

        add(panel, BorderLayout.CENTER);
    }

    public String getNombrePartida() {
        return nombrePartida;
    }

    public boolean isConfirmacion() {
        return confirmacion;
    }
}
