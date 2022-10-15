package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioAceptado {

	private Usuario usuario;
	private Desafio desafio;
	private boolean estaCompleto;
	private double porcentajeCompletitud;
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

}
