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
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "El costo de ir al hospital es " + costoSalud + ". ¿Desea continuar?",
                        "Confirmar Operación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (CompraVenta.comprobarDineroDisponible(costoSalud, perfil.getFondos())) {
                        perfil.setSalud(CiudadActividad.irHospital(perfil.getSalud()));
                        perfil.setFondos(perfil.getFondos() - costoSalud);
                        panelPerfil.actualizarInformacion();
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fondos insuficientes para ir al hospital.",
                                "Fondos insuficientes",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        loteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoLoteria = CiudadActividad.getCostoLoteria();
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "El costo de compra un boleto de loteria es " + costoLoteria + ". ¿Desea continuar?",
                        "Confirmar Operación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if (CompraVenta.comprobarDineroDisponible(costoLoteria, perfil.getFondos())) {
                        int premio = CiudadActividad.calcularPremioLoteria();
                        perfil.setFondos(perfil.getFondos() + premio);
                    	perfil.setFondos(perfil.getFondos() - costoLoteria);
                        perfil.setGanancias(perfil.getGanancias()+premio);
                        perfil.setPerdidas(perfil.getPerdidas()+costoLoteria);
                    	panelPerfil.actualizarInformacion(); 
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fondos insuficientes para realizar la compra.",
                                "Fondos insuficientes",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        almacenes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoEspacio = CiudadActividad.getCostoEspacio();
                int confirmacion = JOptionPane.showConfirmDialog(null,
                        "El costo de compra espacio de almacen es " + costoEspacio + ". ¿Desea continuar?",
                        "Confirmar Operación",
                        JOptionPane.YES_NO_OPTION);
                if (confirmacion == JOptionPane.YES_OPTION) {
                    if(CompraVenta.comprobarDineroDisponible(costoEspacio,perfil.getFondos())){
                    	perfil.getAlmacen().setEspacioTotal(CiudadActividad.aumentarEspacio(perfil.getAlmacen().getEspacioTotal()));
                    	perfil.setFondos(perfil.getFondos() - costoEspacio);
                    	panelPerfil.actualizarInformacion(); 	
                    } else {
                        JOptionPane.showMessageDialog(null,
                                "Fondos insuficientes para realizar la compra.",
                                "Fondos insuficientes",
                                JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        add(hospital);
        add(loteria);
        add(almacenes);
    }
}