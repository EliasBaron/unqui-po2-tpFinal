package ar.edu.unq.po2.tpFinal;

public class Categoria {

	private String nombre;
	
	public Categoria(String nombre) {
		this.setNombre(nombre);
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return this.nombre;
	}

}
