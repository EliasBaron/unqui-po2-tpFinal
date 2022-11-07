package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioNoAceptado extends EstadoDesafioUsuario{

	private DesafioUsuario desafioUsuario;
	
	public DesafioNoAceptado(DesafioUsuario desafioUsuario) {
		this.desafioUsuario = desafioUsuario;
	}

	@Override
	public Date getMomentoSuperacion(){
		return null;
	}

	@Override
	public boolean getEstaCompleto() {
		return false;
	}


	@Override
	public boolean estaAceptadoAlMomento() {
		return false;
	}

	@Override
	public boolean fueAceptadoPreviamente() {
		return false;
	}

	@Override
	public void evaluarMuestra(Muestra muestra, Desafio desafio) {
	}

	@Override
	public boolean puedeSerCalificado() {
		return false;
	}
	
}
