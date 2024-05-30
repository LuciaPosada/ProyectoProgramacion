package com.lucia.interfaz;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import com.lucia.app.Serializador;
import com.lucia.perfil.Perfil;

public class VentanaPrincipal extends JFrame {

    private static HashMap<String, Perfil> partidasGuardadas = new HashMap<>();

    private PanelInicio panelInicio;
    private PanelJuego panelPartida;
    private PanelPuntuaciones panelPuntuaciones; 
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        setTitle("Especulacion Financiera para Dummies");
        setSize(620, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        partidasGuardadas = Serializador.cargarDatos("partidasGuardadas.txt");

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Paneles
        panelInicio = new PanelInicio();
        panelPartida = new PanelJuego();
        panelPuntuaciones = new PanelPuntuaciones();

        // Funcionalidad botones del panelInicio
        panelInicio.getBtnNuevaPrt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogPedirNombre(true);
            }
        });
        panelInicio.getBtnCargarPrt().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostrarDialogPedirNombre(false);
            }
        });
        panelInicio.getBtnPuntuacion().addActionListener(e -> cardLayout.show(getContentPane(), "panelP2"));

        add(panelInicio, "panelInicio");
        add(panelPartida, "panelPartida");
        add(panelPuntuaciones, "panelP2");

        cardLayout.show(getContentPane(), "panelInicio");
    }

    /**
    * Muestra el dialogo de pedir nombre y maneja la creación o carga de un perfil.
    * @param nuevaPartida indica si se está creando una nueva partida (true) o cargando una existente (false)
    */
    private void mostrarDialogPedirNombre(boolean nuevaPartida) {
        DialogPedirNombre dialog = new DialogPedirNombre(this);
        dialog.setVisible(true);
        if (dialog.isConfirmacion()) {
            String nombrePartida = dialog.getNombrePartida();
            if (nuevaPartida) {
                crearNuevaPartida(nombrePartida);
            } else {
                cargarPartidaExistente(nombrePartida);
            }
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
    * Carga una partida existente desde partidasGuardadas.
    * @param nombrePartida el nombre de la partida a cargar
    */
    private void cargarPartidaExistente(String nombrePartida) {
        Perfil perfilCargado = partidasGuardadas.get(nombrePartida);
        if (perfilCargado != null) {
            panelPartida.setPerfil(perfilCargado);
            cardLayout.show(getContentPane(), "panelPartida");
        } else {
            JOptionPane.showMessageDialog(this, "Perfil no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        }
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
