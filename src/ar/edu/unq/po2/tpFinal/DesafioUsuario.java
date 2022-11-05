package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioUsuario {

	private Desafio desafio;
	private EstadoDesafioUsuario estado;
	private int calificacion;
	private Date fechaSuperacion;
	private int cantidadMuestrasTomadas;
	private int cantidadMuestrasNecesarias;

	public DesafioUsuario(Desafio desafio) {
		this.desafio = desafio;
		this.estado = new DesafioNoAceptado(this);
		this.cantidadMuestrasTomadas = 0;
		this.cantidadMuestrasNecesarias = desafio.getCantidadDeMuestrasNecesarias();
	}
	
	public Date getMomentoSuperacion() {
		return estado.getMomentoSuperacion(this.fechaSuperacion);
	}

	public boolean getEstaCompleto() {
		return estado.getEstaCompleto();
	}

	public void setEstado(EstadoDesafioUsuario estado) {
		this.estado = estado;
	}

	public Desafio getDesafio() {
		return this.desafio;
	}
	
	public EstadoDesafioUsuario getEstado() {
		return this.estado;
	}

	public boolean estaAceptadoAlMomento() {
		return estado.estaAceptadoAlMomento();
	}
	
	public void evaluarMuestra(Muestra muestra) {
		estado.evaluarMuestra(muestra, this.desafio);
	}

	public void serAceptado() {
		estado.serAceptadoDesafioUsuario(this);
	}
	
	public void recibirCalificacion(int calificacion) {
		if (estado.puedeSerCalificado()) {
			this.calificacion = calificacion;
		}
	}
	
	public int getCalificacion() {
		return this.calificacion;
	}
	
	public void sumarMuestra(Muestra muestra) {
		cantidadMuestrasTomadas++;
		this.evaluarCompletitud(muestra);
	}
	
	public void evaluarCompletitud(Muestra muestra) {
		if (cantidadMuestrasTomadas == cantidadMuestrasNecesarias) {
			this.setEstado(new DesafioCompleto(this));
		}
	}
	
	public double getPorcentajeCompletitud() {
		return (cantidadMuestrasTomadas / cantidadMuestrasNecesarias) * 100;
	}
}
