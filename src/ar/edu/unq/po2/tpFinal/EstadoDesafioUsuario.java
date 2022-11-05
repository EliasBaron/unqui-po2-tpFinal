package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public abstract class EstadoDesafioUsuario {

	public abstract Date getMomentoSuperacion();

	public abstract boolean getEstaCompleto();
	
	public abstract void evaluarMuestra(Muestra muestra, Desafio desafio);

	public abstract boolean estaAceptadoAlMomento();
	
	public abstract void serAceptadoDesafioUsuario(DesafioUsuario desafioUsuario);

	public abstract boolean puedeSerCalificado();
}
