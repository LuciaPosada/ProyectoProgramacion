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

    private static final String ARCHIVO_DE_GUARDADO = "partidasGuardadas.txt";

    private PanelInicio panelInicio;
    private PanelJuego panelPartida;
    private PanelPuntuaciones panelPuntuaciones; 
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        setTitle("Especulacion Financiera para Dummies");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Intentar cargar los datos y en caso de excepcion, crear un nuevo archivo

        try {
            partidasGuardadas = Serializador.cargarDatos(ARCHIVO_DE_GUARDADO);
            if (partidasGuardadas == null) {
                partidasGuardadas = new HashMap<>();
                Serializador.guardarDatos(ARCHIVO_DE_GUARDADO, partidasGuardadas);
            }
        } catch (Exception e) { 
            partidasGuardadas = new HashMap<>();
            Serializador.guardarDatos(ARCHIVO_DE_GUARDADO, partidasGuardadas);
        }

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
        
        panelInicio.getBtnPuntuacion().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PanelPuntuaciones.actualizarPuntuacionesEnTabla();
                cardLayout.show(getContentPane(), "panelPuntuacione");
            }
        });

        add(panelInicio, "panelInicio");
        add(panelPartida, "panelPartida");
        add(panelPuntuaciones, "panelPuntuaciones");

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
        Serializador.guardarDatos(ARCHIVO_DE_GUARDADO, partidasGuardadas);
    }

    /**
     * Elimina un perfil del HashMap partidasGuardadas y actualiza la serialización.
     * @param nombrePartida el nombre del perfil a eliminar
     */
    public static void eliminarPerfil(String nombrePartida) {
        if (partidasGuardadas.remove(nombrePartida) != null) {
            Serializador.guardarDatos(ARCHIVO_DE_GUARDADO, partidasGuardadas);
            System.out.println("Perfil eliminado con éxito");
        } else {
            System.out.println("Perfil no encontrado");
        }
    }

    public void mostrarPanelInicio() {
        cardLayout.show(getContentPane(), "panelInicio");
    }
}
