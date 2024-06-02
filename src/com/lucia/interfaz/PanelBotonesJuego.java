
package com.lucia.interfaz;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.lucia.actividades.ContadorAños;
import com.lucia.actividades.MercadoActividad;
import com.lucia.perfil.Almacen;
import com.lucia.perfil.Mercado;
import com.lucia.perfil.Perfil;
import com.lucia.puntuacion.Puntuaciones;


public class PanelBotonesJuego extends JPanel {

    private PanelPerfil panelPerfil;

    public PanelBotonesJuego(PanelPerfil panelPerfil) {
        this.panelPerfil = panelPerfil;
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
                    Perfil perfil = panelPerfil.getPerfil();
                    VentanaPrincipal.guardarPerfil(perfil);
                    ventanaPrincipal.mostrarPanelInicio();
                } else if (button.getText().equals("Avanzar Año")) {
                    Perfil perfil = panelPerfil.getPerfil();
                    perfil.setAños(ContadorAños.sumarAño(perfil.getAños()));
                    perfil.setSalud(ContadorAños.empeorarSalud(perfil.getSalud(), perfil.getAños()));
                    if (ContadorAños.comprobarLimiteSalud(perfil.getSalud())){
                        VentanaPrincipal ventanaPrincipal = (VentanaPrincipal) getTopLevelAncestor();
                        ContadorAños.finalizarPartida(perfil);
                        ventanaPrincipal.mostrarPanelInicio();
                    }else{
                        panelPerfil.actualizarInformacion();
                        MercadoActividad.actualizarProductos(Mercado.getProductosEnVenta(),Almacen.getProductosAlmacenados());
                    }
                }
            }
        });
    }
}