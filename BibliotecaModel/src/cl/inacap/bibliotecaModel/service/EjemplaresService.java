package cl.inacap.bibliotecaModel.service;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.bibliotecaModel.dao.EjemplarDAO;
import cl.inacap.bibliotecaModel.dao.LibrosDAO;
import cl.inacap.bibliotecaModel.dto.*;

public class EjemplaresService {
	private EjemplarDAO ejemplarDAO = new EjemplarDAO();
	private LibrosDAO libroDAO= new LibrosDAO();
	
	public EjemplaresService() {
	}
	
	public List<Ejemplar> getAllEjemplaresDisponibles(){
		List<Ejemplar> aux = ejemplarDAO.getAll();
		List<Ejemplar> ejemplares =new ArrayList<Ejemplar>();
		for(Ejemplar ejemplar:aux) {
			if(ejemplar.getEstado().equalsIgnoreCase("Disponible")) {
				ejemplar.setLibro(libroDAO.findByISBN(ejemplar.getIsbn()));
				ejemplares.add(ejemplar);
			}			
		}
		return ejemplares;
	}
	

}
