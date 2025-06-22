package ejercicio1;

public class ValidadorDNI {


	
	public static void verificarDniInvalido(String DNI) throws DniInvalido
	{
		boolean contieneLetra = false;
		
		for(int i = 0 ; i < DNI.length(); i++) {
			char c = DNI.charAt(i);
			
			if(!Character.isDigit(c)) {
				contieneLetra = true;
			}
		}
		
		if (contieneLetra) {
			throw new DniInvalido("El DNI contiene letras o símbolos no válidos.");
		}
		
	}
		
		
}
		
	  
	
	
	
	
