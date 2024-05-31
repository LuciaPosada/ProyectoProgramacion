package com.lucia.interfaz;

import javax.swing.JButton;
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
                if(CompraVenta.comprobarDineroDisponible(costoSalud,perfil.getFondos())){
                    int nuevaSalud = CiudadActividad.irHospital(perfil.getSalud());
                    perfil.setSalud(nuevaSalud);
                    perfil.setFondos(CompraVenta.gastarDinero(perfil.getFondos(), costoSalud));
                    panelPerfil.actualizarInformacion(); 
                }
            }
        });

        loteria.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int costoLoteria = CiudadActividad.getCostoSalud();
                if(CompraVenta.comprobarDineroDisponible(costoLoteria,perfil.getFondos())){
                    int premio = CiudadActividad.calcularPremioLoteria();
                    perfil.setFondos(perfil.getFondos() + premio);
                    perfil.setFondos(CompraVenta.gastarDinero(perfil.getFondos(), costoLoteria));
                    panelPerfil.actualizarInformacion(); 
                }
            }
        });

        add(hospital);
        add(loteria);
        add(almacenes);

    }
    
}
