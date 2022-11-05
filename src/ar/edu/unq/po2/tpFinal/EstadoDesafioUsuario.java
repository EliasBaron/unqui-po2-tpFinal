package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public abstract class EstadoDesafioUsuario {

	public abstract Date getMomentoSuperacion();

	public abstract boolean getEstaCompleto();
	
	public abstract void evaluarMuestra(Muestra muestra);

	protected abstract boolean estaAceptadoAlMomento();

	protected abstract boolean fueAceptado();

	protected abstract double getPorcentajeCompletitud();
}
