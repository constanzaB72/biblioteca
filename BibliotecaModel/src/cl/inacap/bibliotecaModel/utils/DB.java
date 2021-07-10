package cl.inacap.bibliotecaModel.utils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
	
	
	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	
	
	public boolean conectar() {
		try {
			
			//DECIRLE A JAVA QUE MOTOR DE DB ESTOY USANDO
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//CONECCION POR EL DRIVER
			//this.con = DriverManager.getConnection("jdbc:mysql://localhost:33060/BibliotecaV2?serverTimeZone=UTC", "root", "secret");
			
			this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BibliotecaV2?serverTimeZone=UTC", "root", "");
			
			
			return true;
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	public void desconectar() {
		try {
			con.close();
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un error al cerrar la conexion");
		}
	}
	
	
	
}
