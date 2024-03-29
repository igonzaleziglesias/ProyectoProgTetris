package baseDatos;

import excepciones.ExcepcionSql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;


public class Quest {

    ArrayList<Jugador> lista = new ArrayList<Jugador>();

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:puntuacion.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public ArrayList<Jugador> selectAll() throws ExcepcionSql {
        String sql = "SELECT name, puntos, id FROM puntuacion";
        int exception;
        try (Connection conn = this.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Jugador alum = new Jugador(rs.getInt("id"), rs.getString("name"), rs.getString("puntos"));
//                alumno[2] = rs.getInt("id");
//                alumno[0] = rs.getString("name");
//                alumno[1] = rs.getString("puntos");

                lista.add(alum);
            }
            exception = 0;
        } catch (SQLException e) {

            System.out.println(e.getMessage());
            exception = 1;
        }

        if (exception == 1) {
            throw new ExcepcionSql("Fallo la seleccion");
        }
        try {
            this.connect().close();
        } catch (SQLException ex) {

        }
        Collections.sort(lista);
//        for (int i=0 ;i<lista.size();i++){
//            System.out.println(lista.get(i).getName());
//        }
        return lista;

    }

}
