package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioNoAceptado extends EstadoDesafioUsuario{

	DesafioUsuario desafioUsuario;
	
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
	public void evaluarMuestra(Muestra muestra) {
	}

	@Override
	protected boolean estaAceptadoAlMomento() {
		return false;
	}

	@Override
	protected boolean fueAceptado() {
		return false;
	}
	
}
