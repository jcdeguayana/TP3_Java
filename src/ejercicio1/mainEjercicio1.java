package ejercicio1;

import java.util.TreeSet;

public class mainEjercicio1 {

	public static void main(String[] args) {
		
		Archivo archivo = new Archivo();
		/*archivo.setRuta("src/Personas.txt");*/
		TreeSet<Persona> list = new TreeSet<Persona>();
		
		if(archivo.existe()) {
		System.out.println("Existe archivo");
		list = archivo.leerPersonas();
		archivo.escribirResultado(list);
		}
		else {
			System.out.println("No existe archivo");
		}
	}

}
