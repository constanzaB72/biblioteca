package cl.inacap.bibliotecaModel.service;

import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;

public class LoginService {
	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();
	ClientesDAO clienteDAO = new ClientesDAO();

	public boolean validarUsuario(String usuario, String password, String tipoUsuario) {
		if (tipoUsuario.equals("Trabajador")) {
			return trabajadorDAO.usuarioValido(usuario, password);
		}
		if (tipoUsuario.equals("Cliente")) {
			return clienteDAO.usuarioValido(usuario, password);
		}
		return false;

	}

}
