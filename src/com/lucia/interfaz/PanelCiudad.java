package com.lucia.interfaz;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.lucia.actividades.CiudadActividad;
import com.lucia.actividades.CompraVenta;
import com.lucia.perfil.Perfil;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelCiudad extends JPanel{

    private Perfil perfil;
    private PanelPerfil panelPerfil;

    public PanelCiudad(Perfil perfil,PanelPerfil panelPerfil) {
        this.perfil = perfil;
        this.panelPerfil = panelPerfil;
        setLayout(new GridLayout(3,1));

        JButton hospital = new JButton("Ir al Hospital");
        JButton loteria = new JButton("Comprar un billete de loteria");
        JButton almacenes = new JButton("Aumentar espacio de almacen");

        hospital.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoSalud = CiudadActividad.getCostoSalud();

                    if (CompraVenta.comprobarDineroDisponible(costoSalud, perfil.getFondos())) {
                        perfil.setSalud(CiudadActividad.irHospital(perfil.getSalud()));
                        perfil.setFondos(CompraVenta.gastarDinero(perfil.getFondos(), costoSalud));
                        panelPerfil.actualizarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fondos insuficientes para ir al hospital.",
                                "Fondos insuficientes",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
  
        });

        loteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoLoteria = CiudadActividad.getCostoSalud();
                if(CompraVenta.comprobarDineroDisponible(costoLoteria,perfil.getFondos())){
                    perfil.setFondos(perfil.getFondos() + CiudadActividad.calcularPremioLoteria());
                    perfil.setFondos(CompraVenta.gastarDinero(perfil.getFondos(), costoLoteria));
                    panelPerfil.actualizarInformacion(); 
                }
            }
        });

        almacenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoEspacio = CiudadActividad.getCostoSalud();
                if(CompraVenta.comprobarDineroDisponible(costoEspacio,perfil.getFondos())){
                    perfil.getAlmacen().setEspacioAlmacen(CiudadActividad.aumentarEspacio(perfil.getAlmacen().getEspacioAlmacen()));
                    perfil.setFondos(CompraVenta.gastarDinero(perfil.getFondos(), costoEspacio));
                    panelPerfil.actualizarInformacion(); 
                }
            }
        });

        add(hospital);
        add(loteria);
        add(almacenes);

    }
    
}
