package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public abstract class EstadoDesafioUsuario {

	public abstract Date getMomentoSuperacion(Date fechaSuperacion);

	public abstract boolean getEstaCompleto();
	
	public abstract void evaluarMuestra(Muestra muestra, Desafio desafio);

	public abstract boolean estaAceptadoAlMomento();

	public abstract boolean puedeSerCalificado();

	protected abstract boolean fueAceptadoPreviamente();
}
