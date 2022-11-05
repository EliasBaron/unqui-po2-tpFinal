package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioUsuario {

//	private Usuario usuario;
	private Desafio desafio;
	private EstadoDesafioUsuario estado;
	private int calificacion;

	public DesafioUsuario(Desafio desafio) {
//		this.usuario = usuario;s
		this.desafio = desafio;
		this.estado = new DesafioNoAceptado(this);
	}
	
	public Date getMomentoSuperacion() {
		return estado.getMomentoSuperacion();
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
		estado.evaluarMuestra(muestra);
	}

	public boolean fueAceptado() {
		return estado.fueAceptado();
	}

	public void serAceptado() {
		this.setEstado(new DesafioAceptado(this, this.desafio));
	}
	
	public void recibirCalificacion(int calificacion) {
		this.calificacion = calificacion;
	}
	
	public int getCalificacion() {
		return this.calificacion;
	}

	public double getPorcentajeCompletitud() {
		return estado.getPorcentajeCompletitud();
	}
	
//	public double getPorcentajeCompletitud() {
//		return (cantidadMuestrasTomadas / desafio.getCantidadDeMuestrasNecesarias()) * 100;
//	}

}
