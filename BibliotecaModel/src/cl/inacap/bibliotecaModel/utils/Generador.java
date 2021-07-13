package cl.inacap.bibliotecaModel.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Generador {
	
	DB db = new DB();
	
	public int generarNumSerie() {
		
		int n1 = 0;
		int n2 = 0;
		int n3 = 0;
		int n4 = 0;
		
		for(int i= 0; i < 4; i++) {
			
			if(n1 == 0) {
				n1 = (int)(Math.random()*9+1);
			}else if(n2 == 0) {
				n2 = (int)(Math.random()*9+1);
			}else if(n3 == 0) {
				n3 = (int)(Math.random()*9+1);
			}else if(n4 == 0) {
				n4 = (int)(Math.random()*9+1);
			}
			
		}
		
		int result = Integer.valueOf(String.valueOf(n1) + String.valueOf(n2) + String.valueOf(n3) + String.valueOf(n4));
		
		return result;
	}

	public String generarFechaActual() {
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate fecha = LocalDate.now();
		String fechaActual = fecha.format(formatter2);
		
		return fechaActual;
	}
	
	
	public String generarHoraActual() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime hora = LocalTime.now();
		String horaActual = hora.format(formatter);
		
		
		return horaActual;
	}
	
	public int generarFolioBoleta() {
		try {
			db.conectar();
			String query = "SELECT Folio FROM BibliotecaV2.Boletas WHERE Folio=(SELECT MAX(Folio) FROM BibliotecaV2.Boletas)";
			PreparedStatement st = db.getCon().prepareStatement(query);
			ResultSet rs = st.executeQuery();
			
			int folio = 0;
			while(rs.next()) {
				folio = rs.getInt(1) + 1;
			}
			
			return folio;
			
		}catch(Exception ex) {
			System.out.println("Se Produjo un Error al Generar el FOLIO");
			return 0;
		}finally {
			db.desconectar();
		}
	}
}
