package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioCompleto extends EstadoDesafioUsuario {

	DesafioUsuario desafioUsuario;
	Date fechaSuperacion;
	
	public DesafioCompleto(DesafioUsuario desafioUsuario, Date fechaSuperacion) {
		this.desafioUsuario = desafioUsuario;
		this.fechaSuperacion = fechaSuperacion;
	}

	@Override
	public Date getMomentoSuperacion() {
		return this.fechaSuperacion;
	}

	@Override
	public boolean getEstaCompleto() {
		return true;
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
		return true;   // como es un desafio completo en algun momento fué aceptado (para no poder repetir desafios)
	}

	@Override
	protected double getPorcentajeCompletitud() {
		return 100;
	}

}
