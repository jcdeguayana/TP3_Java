package ejercicio1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TreeSet;
import java.io.File;

public class Archivo {
	
	private String ruta;
	
	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Archivo() {
		this.ruta = "src/Personas.txt";
	}
	
	public boolean existe()
	{
		File archivo = new File(ruta); 
		if(archivo.exists())
		      return true;
		return false;
	}
	
	public TreeSet<Persona> leerPersonas(){
		TreeSet<Persona> personas = new TreeSet<Persona>();
		
		try {
			FileReader fReader = new FileReader(ruta);
			BufferedReader buffer = new BufferedReader(fReader);
			
			String linea;
			
			while( (linea = buffer.readLine()) != null ) {
				
				if(linea.isEmpty()) continue;
				
				Persona persona = new Persona();
				String[] lineas = linea.split("-");
				
				persona.setNombre(lineas[0]);
				persona.setApellido(lineas[1]);
				
				try {
				ValidadorDNI.verificarDniInvalido(lineas[2]);
				persona.setDni(lineas[2]);
				System.out.println(persona);
				personas.add(persona);
				}catch(DniInvalido e) {
					System.out.println("Error en la carga de: " + persona.getNombre() + " " + persona.getApellido() + " " + e.getMessage());
				}
			}
			
			buffer.close();
			fReader.close();
			
		} catch(IOException e) {
			System.out.println("Error" + e.getMessage());
			return null;
		}
		
		return personas;
	}
	
	public boolean escribirResultado(TreeSet<Persona> lista) {
		String rutaSalida = "src/Resultado.txt";
		
		//verifico que la lista sea correcta para seguir
		if (lista == null || lista.isEmpty()) {
		    System.out.println("La lista está vacía o es nula.");
		    return false;
		}
		
		try {
			FileWriter fWriter = new FileWriter(rutaSalida, false); 
			BufferedWriter bWriter = new BufferedWriter(fWriter);
			for (Persona persona : lista) {
				String linea = persona.toString(); //uso el método toString para mantener el formato
				bWriter.write(linea);
				bWriter.newLine(); //salto de linea
			}
			//cierro los archivos
			bWriter.close();
			fWriter.close();
			
		}catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
	
}
