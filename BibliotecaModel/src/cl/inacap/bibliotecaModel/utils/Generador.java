package cl.inacap.bibliotecaModel.utils;

public class Generador {
	
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


}
