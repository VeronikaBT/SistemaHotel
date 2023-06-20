package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	

    public Conexion() {
    }
	public Connection conectar() {
             Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3307/gestionhotel";
			String user="root";
			String pass="";
			conn = DriverManager.getConnection(url,user,pass);
		}catch(ClassNotFoundException | SQLException ex) {
			System.err.println("Error de conexion: "+ex.getMessage());
		}
		return conn;
	}
	
}
