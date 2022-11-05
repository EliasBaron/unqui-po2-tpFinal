package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioCompleto extends EstadoDesafioUsuario {

	DesafioUsuario desafioUsuario;

	
	public DesafioCompleto(DesafioUsuario desafioUsuario) {
		this.desafioUsuario = desafioUsuario;
	}

	@Override
	public Date getMomentoSuperacion() {
		return desafioUsuario.fechaSuperacion;
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
	public void serAceptadoDesafioUsuario(DesafioUsuario desafioUsuario) {
		
	}

	@Override
	public void evaluarMuestra(Muestra muestra, Desafio desafio) {
		
	}

	@Override
	public boolean puedeSerCalificado() {
		return true;
	}

}
