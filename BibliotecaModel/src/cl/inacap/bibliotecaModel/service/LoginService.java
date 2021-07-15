package cl.inacap.bibliotecaModel.service;

import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;

public class LoginService {
	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();

	public boolean validarUsuario(String usuario, String password) {
		return trabajadorDAO.usuarioValido(usuario, password);

	}

}
