package cl.inacap.bibliotecaModel.utils;

public class RutUtils {

	
	/*
	 * String rut = request.getParameter("rut-txt").trim (); if
	 * (validarRut(rut).equals("Valido")) { if (trabajadoresDAO.trabaRut(rut)) {
	 * errores.add("registrado,verifique");
	 * 
	 * }else { errores.add(ValidarRut(rut));
	 * 
	 * } }
	 */
	
	public String validarRut(String rutConDig) {
		String[] aux = rutConDig.split("-");
		aux[0]=aux[0].replace(".","");
		if(aux.length !=2) {
			return "Formato de Rut 'no valido'";
		}
		Integer num=0;
		try {
			num=Integer.parseInt(aux[0]);
			Integer m=0, s =1;
			for (; num !=0; num/=10) {
				s=(s + num % 10 * (9 - m++ %6)) %11;
			}
			if (aux[1].equals(((char) (s !=0 ? s + 47 : 75)) + "")) {
				return "Valido";
			}else {
				return "Digito verificador incorrecto";
			}
		}catch (Exception e) {
			return "Rut no valido";
		}
	}
}

	