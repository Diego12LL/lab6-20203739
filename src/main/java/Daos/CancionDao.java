package Daos;

import Beans.Cancion;

import java.sql.*;
import java.util.ArrayList;

public class CancionDao {

    public ArrayList<Cancion> listarCancioneRecomendadas() {
        ArrayList<Cancion> listaCancionesRecomen = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT cancion_idcancion, c.nombre_cancion, c.banda, count(*) FROM lab6sw1.reproduccion r\n" +
                "inner join cancion c on r.cancion_idcancion = c.idcancion \n" +
                "group by cancion_idcancion having count(*)>2 \n" +
                "order by count(*) desc;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Cancion cancionRecomendada = new Cancion();
                cancionRecomendada.setIdCancion(resultSet.getInt(1));
                cancionRecomendada.setNombre_cancion(resultSet.getString(2));
                cancionRecomendada.setBanda(resultSet.getString(3));
                listaCancionesRecomen.add(cancionRecomendada);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesRecomen;
    }

    public ArrayList<Cancion> listarCancionesPorBanda() {
        ArrayList<Cancion> listaCancionesPorBanda = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM lab6sw1.cancion\n" +
                "order by banda;";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Cancion cancionOrdenada = new Cancion();
                cancionOrdenada.setIdCancion(resultSet.getInt(1));
                cancionOrdenada.setNombre_cancion(resultSet.getString(2));
                cancionOrdenada.setBanda(resultSet.getString(3));
                listaCancionesPorBanda.add(cancionOrdenada);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCancionesPorBanda;
    }

    public ArrayList<Cancion> listarCanciones() {
        ArrayList<Cancion> listaCanciones = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "SELECT * FROM lab6sw1.cancion";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             Statement stmt = connection.createStatement();
             ResultSet resultSet = stmt.executeQuery(sql)) {

            while (resultSet.next()) {
                Cancion cancion = new Cancion();
                cancion.setIdCancion(resultSet.getInt(1));
                cancion.setNombre_cancion(resultSet.getString(2));
                cancion.setBanda(resultSet.getString(3));
                listaCanciones.add(cancion);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCanciones;
    }

    public void actualizarEstado(int idcancion) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        String sql = "UPDATE cancion SET estado = 1 WHERE idcancion = ?;";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idcancion);

            pstmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Cancion listar(String id) {
        Cancion cancion = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String sql = "select * from cancion where idcancion = ?";
        String url = "jdbc:mysql://localhost:3306/lab6sw1?serverTimezone=America/Lima";
        try (Connection connection = DriverManager.getConnection(url, "root", "root");
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()) {
                if (rs.next()) {
                    cancion = new Cancion();
                    cancion.setIdCancion(rs.getInt(1));
                    cancion.setNombre_cancion(rs.getString(2));
                    cancion.setBanda(rs.getString(3));
                    cancion.setEstado(rs.getBoolean(4));
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return cancion;
    }

}
