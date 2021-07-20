package cl.inacap.bibliotecaModel.service;

import cl.inacap.bibliotecaModel.dao.ClientesDAO;
import cl.inacap.bibliotecaModel.dao.TrabajadoresDAO;

/**
 * Clase encargada de proveer de un metodo para poder validar un Tipo de Usuario
 * utilizando la conexion a una base de datos , juntos con parametros como lo
 * son el usuario y la password.
 * 
 * CREADO EL DIA 12-07-2021
 * 
 * @author Constanza Benavides
 *
 */
public class LoginService {
	TrabajadoresDAO trabajadorDAO = new TrabajadoresDAO();
	ClientesDAO clienteDAO = new ClientesDAO();

	/**
	 * Metodo de Tipo Boolean encargado de llamar a un metodo validador de usuario
	 * en una base de datos. El metodo recibe 3 parametros de tipo String, un
	 * usuario y password , junto con un tipo de usuario que nos permite con la
	 * ayuda de una sentencia IF poder validar que tipo de metodo llamar para
	 * validar el tipo de usuario. El metodo retorna un False por defecto, en caso
	 * de que alguno de los metodos llamados al interior de las sentencias IF
	 * exista, retornara un True.
	 * 
	 * 
	 * CREADO EL DIA 12-07-2021
	 * 
	 * @author Constanza Benavides
	 * @param usuario
	 * @param password
	 * @param tipoUsuario
	 * @return True si algunos de los 2 es Valido, Valor Default False.
	 */
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
