package cl.inacap.bibliotecaModel.service;

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
		List<Ejemplar> ejemplares = ejemplarDAO.getAll();
		for(Ejemplar ejemplar:ejemplares) {
			if(!ejemplar.getEstado().equalsIgnoreCase("Disponible")) {
				ejemplares.remove(ejemplar);
				continue;
			}
			ejemplar.setLibro(libroDAO.findByISBN(ejemplar.getIsbn()));
			
		}
		return ejemplares;
	}
	

}
