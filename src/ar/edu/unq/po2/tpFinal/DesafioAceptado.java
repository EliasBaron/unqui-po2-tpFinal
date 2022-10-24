package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioAceptado {

	private Usuario usuario;
	private Desafio desafio;
	private boolean estaCompleto;
	private int cantidadMuestrasTomadas;
	private Date fechaSuperacion;
	private int calificacion;

	public DesafioAceptado(Usuario usuario, Desafio desafio) {
		this.usuario = usuario;
		this.desafio = desafio;
		this.estaCompleto = false;
	}
	
	public Date getMomentoSuperacion() {
		return fechaSuperacion;
	}

	public boolean getEstaCompleto() {
		return estaCompleto;
	}

	public void evaluarMuestra(Muestra muestra) {
		if (!estaCompleto && desafio.esMuestraValida(muestra)) {
			cantidadMuestrasTomadas++;
			this.evaluarCompletitud(muestra);
		}
	}
	
	public void evaluarCompletitud(Muestra muestra) {
		if (cantidadMuestrasTomadas == desafio.getCantidadDeMuestrasNecesarias()) {
			estaCompleto = true;
			fechaSuperacion = muestra.getFecha();
		}
	}
	
	public double getPorcentajeCompletitud() {
		return (cantidadMuestrasTomadas / desafio.getCantidadDeMuestrasNecesarias()) * 100;
	}

}
