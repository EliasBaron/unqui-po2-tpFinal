package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioCompleto extends EstadoDesafioUsuario {

	private DesafioUsuario desafioUsuario;

	
	public DesafioCompleto(DesafioUsuario desafioUsuario) {
		this.desafioUsuario = desafioUsuario;
	}

	@Override
	public Date getMomentoSuperacion() {
		return desafioUsuario.obtenerFechaSuperacion();
	}

	@Override
	public boolean getEstaCompleto() {
		return true;
	}

	@Override
	public boolean estaAceptadoAlMomento() {
		return false;
	}

	@Override
	public boolean fueAceptadoPreviamente() {
		return true;
	}

	@Override
	public void evaluarMuestra(Muestra muestra, Desafio desafio) {
		
	}

	@Override
	public boolean puedeSerCalificado() {
		return true;
	}

}
