package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Desafio {
	private int cantidadDeMuestrasNecesarias;
	private int dificultad;
	private int recompensa;
	private Area areaDesafio;
	private List<RestriccionTemporal> restriccionesTemporales;

	public Desafio(int cantidadDeMuestrasNecesarias, int dificultad, int recompensa, Area areaDesafio, List<RestriccionTemporal> restriccionesTemporales) {
		this.cantidadDeMuestrasNecesarias = cantidadDeMuestrasNecesarias;
		this.dificultad = dificultad;
		this.recompensa = recompensa;
		this.areaDesafio = areaDesafio;
		this.restriccionesTemporales = restriccionesTemporales;
	}
	
	public int getCantidadDeMuestrasNecesarias() {
		return cantidadDeMuestrasNecesarias;
	}
	
	public boolean esMuestraValida(Muestra muestra) {
		return this.verificarRestriccionesTemporales(muestra) && areaDesafio.verificarCoordenada(muestra.getCoordenada());
	}
	
	public boolean verificarRestriccionesTemporales(Muestra muestra) {
		return restriccionesTemporales.stream().allMatch(restriccionTemporal -> restriccionTemporal.verificar(muestra.getFecha()));
	}

}
