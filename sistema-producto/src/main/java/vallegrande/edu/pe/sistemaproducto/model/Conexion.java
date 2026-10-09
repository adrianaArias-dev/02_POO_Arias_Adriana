package vallegrande.edu.pe.sistemaproducto.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    // Se cambia el puerto a 3308 conforme al mapeo del contenedor Docker
    private static final String URL = "jdbc:mysql://localhost:3308/sistemaproductos";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConexion() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}