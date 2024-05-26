package com.lucia.interfaz;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JPanel;
import com.lucia.app.Serializador;
import com.lucia.perfil.Perfil;

public class VentanaPrincipal extends JFrame {

    private static HashMap<String, Perfil> partidasGuardadas = new HashMap<>();

    private PanelInicio panelInicio;
    private PanelJuego panelPartida;
    private JPanel panelPrueba2; // Placeholder - Panel Puntuaciones
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        setTitle("Especulacion Financiera para Dummies");
        setSize(700, 350);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        partidasGuardadas = Serializador.cargarDatos("partidasGuardadas.txt");

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Paneles
        panelInicio = new PanelInicio();
        panelPartida = new PanelJuego();
        panelPrueba2 = new JPanel();
        panelPrueba2.setBackground(Color.MAGENTA);

        // Funcionalidad botones del panelInicio
        panelInicio.getBtnNuevaPrt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogPedirNombre();
            }
        });
        panelInicio.getBtnCargarPrt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogPedirNombre();
            }
        });
        panelInicio.getBtnPuntuacion().addActionListener(e -> cardLayout.show(getContentPane(), "panelP2"));

        add(panelInicio, "panelInicio");
        add(panelPartida, "panelPartida");
        add(panelPrueba2, "panelP2");

        cardLayout.show(getContentPane(), "panelInicio");
    }

    /**
     * Muestra el dialogo de pedir nombre
     */
    private void mostrarDialogPedirNombre() {
        DialogPedirNombre dialog = new DialogPedirNombre(this);
        dialog.setVisible(true);
        if (dialog.isConfirmacion()) {
            panelPartida.setPerfil(new Perfil(dialog.getNombrePartida()));
            cardLayout.show(getContentPane(), "panelPartida");
        }
    }

    /**
    * Crea una nueva partida y la agrega a partidasGuardadas.
    * @param nombrePartida el nombre de la nueva partida
    */
    private void crearNuevaPartida(String nombrePartida) {
        Perfil nuevoPerfil = new Perfil(nombrePartida);
        panelPartida.setPerfil(nuevoPerfil);
        partidasGuardadas.put(nombrePartida, nuevoPerfil);
        cardLayout.show(getContentPane(), "panelPartida");
    }

    /**
     * Guarda el perfil en partidasGuardadas y serializa el HashMap
     * @param perfil el perfil a guardar
     */
    public static void guardarPerfil(Perfil perfil) {
        partidasGuardadas.put(perfil.getNombrePerfil(), perfil);
        Serializador.guardarDatos("partidasGuardadas.txt", partidasGuardadas);
    }

    public void mostrarPanelInicio() {
        cardLayout.show(getContentPane(), "panelInicio");
    }

    public static void main(String[] args) {
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.setVisible(true);
    }
}
