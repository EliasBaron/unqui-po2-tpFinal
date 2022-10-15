package ar.edu.unq.po2.tpFinal;

public class Desafio {
	private int cantidadDeMuestras;
	private int dificultad;
	private int recompensa;
	private Area area;
	private RestriccionTemporal restricciones;

	public Desafio(int cantidadDeMuestras, int dificultad, int recompensa, Area area,RestriccionTemporal restricciones) {
		this.cantidadDeMuestras = cantidadDeMuestras;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.area = area;
		this.restricciones = restricciones;
	}
	
	public boolean verificarMuestra(Muestra muestra) {}

}
