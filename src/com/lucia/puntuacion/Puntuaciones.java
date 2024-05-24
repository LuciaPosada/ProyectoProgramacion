
package com.lucia.puntuacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Puntuaciones {

    private static final String URL = "jdbc:postgresql://localhost:5432/proyecto";

    private static final String USER = "postgres";

    private static final String PASSWORD = "postgres";
    
    public static void crearPuntuacion(String nombre,int puntuacion) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO public.puntuaciones (nompart,puntuacion) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, nombre);
            statement.setInt(2, puntuacion);

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                System.out.println("INSERT 1");
            } else {
                System.out.println("INSERT 0");
            }
        } catch (SQLException e) {
            System.out.println("Error al añadir fila: " + e.getMessage());
        }
    }

        public static Puntuacion obtenerPuntuacionPorNombre(String nombreBuscar) {
        Puntuacion puntuacionEncontrada = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT nompart,puntuaciones FROM public.puntuaciones WHERE nombre = ?";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, nombreBuscar);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nompart");
                        int puntuacionBase = resultSet.getInt("puntuacion");
                        puntuacionEncontrada = new Puntuacion(puntuacionBase,nombre);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener puntuacion: " + e.getMessage());
        }
        return puntuacionEncontrada;
    }

}
