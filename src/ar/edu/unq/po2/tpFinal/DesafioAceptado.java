package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioAceptado extends EstadoDesafioUsuario{

	private DesafioUsuario desafioUsuario;
	
	
	public DesafioAceptado(DesafioUsuario desafioUsuario) {
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
		return true;
	}

	@Override
	public boolean fueAceptadoPreviamente() {
		return true;
	}

	@Override
	public void evaluarMuestra(Muestra muestra, Desafio desafio) {
		if (desafio.esMuestraValida(muestra)) {
			desafioUsuario.sumarMuestra(muestra);
		}
	}

	@Override
	public boolean puedeSerCalificado() {
		return true;
	}

	
	
}
