package com.lucia.interfaz;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.lucia.puntuacion.Puntuacion;
import com.lucia.puntuacion.Puntuaciones;

import java.awt.*;
import java.util.ArrayList;

public class PanelPuntuaciones extends JPanel {

    private static DefaultTableModel modeloTabla;
    private JTable tablaPuntuaciones;

    public PanelPuntuaciones() {
        setLayout(new BorderLayout());

        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Puntuación");
        modeloTabla.addColumn("Ganancias");
        modeloTabla.addColumn("Pérdidas");
        modeloTabla.addColumn("Años");

        tablaPuntuaciones = new JTable(modeloTabla);
        tablaPuntuaciones.setFont(new Font("Arial", Font.PLAIN, 15));

        JScrollPane scrollPane = new JScrollPane(tablaPuntuaciones);
        add(scrollPane, BorderLayout.CENTER);

        cargarPuntuacionesEnTabla();
    }

    private static  void cargarPuntuacionesEnTabla() {
        ArrayList<Puntuacion> puntuaciones = Puntuaciones.obtenerTodasLasPuntuaciones();

        for (Puntuacion puntuacion : puntuaciones) {
            Object[] fila = {puntuacion.nombre, puntuacion.puntuacion, puntuacion.ganancias, puntuacion.perdidas, puntuacion.años};
            modeloTabla.addRow(fila);
        }
    }

}
