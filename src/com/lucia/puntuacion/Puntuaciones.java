
package com.lucia.puntuacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Puntuaciones {

    private static final String URL = "jdbc:postgresql://localhost:5432/Proyecto";

    private static final String USER = "postgres";

    private static final String PASSWORD = "postgres";

    /**
     * Crea una nueva puntuación en la base de datos
     * @param puntuacionObj objeto de tipo Puntuacion que contiene el nombre y la puntuacion de la partida
     */
    public static void crearPuntuacion(Puntuacion puntuacionObj) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "INSERT INTO public.\"puntuaciones\" (nompart, puntuaciones) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, puntuacionObj.nombre);
            statement.setInt(2, puntuacionObj.puntuacion);

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

    /**
     * Obtiene una puntuación por el nombre de la partida
     * @param nombreBuscar identificador de la partida que se quiere buscar
     * @return La puntuación encontrada, o null si no se encuentra
     */
    public static Puntuacion obtenerPuntuacionPorNombre(String nombreBuscar) {
        Puntuacion puntuacionEncontrada = null;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT nompart,puntuaciones FROM public.\"puntuaciones\" WHERE nombre = \"?\"";
            try (PreparedStatement statement = conn.prepareStatement(query)) {
                statement.setString(1, nombreBuscar);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        String nombre = resultSet.getString("nompart");
                        int puntuacionBase = resultSet.getInt("puntuaciones");
                        puntuacionEncontrada = new Puntuacion(puntuacionBase,nombre);
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener puntuacion: " + e.getMessage());
        }
        return puntuacionEncontrada;
    }

    /**
     * Obtiene todas las puntuaciones de la base de datos, ordenadas alfabéticamente por nombre.
     * @return ArrayList de las puntuaciones
     */
    public static ArrayList<Puntuacion> obtenerTodasLasPuntuaciones() {
        ArrayList<Puntuacion> listaPuntuaciones = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String query = "SELECT nompart, puntuaciones FROM public.\"puntuaciones\" ORDER BY nompart";
            try (PreparedStatement statement = conn.prepareStatement(query);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    String nombre = resultSet.getString("nompart");
                    int puntuacion = resultSet.getInt("puntuaciones");
                    Puntuacion puntuacionObj = new Puntuacion(puntuacion,nombre);
                    listaPuntuaciones.add(puntuacionObj);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener todas las puntuaciones: " + e.getMessage());
        }

        return listaPuntuaciones;
    }
}
