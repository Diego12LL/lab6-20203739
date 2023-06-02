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
        String url = "jdbc:mysql://localhost:3306/lab6sw1";
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
}
