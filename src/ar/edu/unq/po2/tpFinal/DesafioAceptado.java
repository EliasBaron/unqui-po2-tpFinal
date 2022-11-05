package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class DesafioAceptado extends EstadoDesafioUsuario{

	DesafioUsuario desafioUsuario;
	Desafio desafio;
	int cantidadMuestrasTomadas;
	int cantidadMuestrasNecesarias;
	
	public DesafioAceptado(DesafioUsuario desafioUsuario, Desafio desafio) {
		this.desafioUsuario = desafioUsuario;
		this.cantidadMuestrasTomadas = 0;
		this.desafio = desafio;
		this.cantidadMuestrasNecesarias = desafio.getCantidadDeMuestrasNecesarias();
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
		if (desafio.esMuestraValida(muestra)) {
			cantidadMuestrasTomadas++;
			this.evaluarCompletitud(muestra);
		}
	}
	
	public void evaluarCompletitud(Muestra muestra) {
		if (cantidadMuestrasTomadas == cantidadMuestrasNecesarias) {
			desafioUsuario.setEstado(new DesafioCompleto(desafioUsuario, muestra.getFecha()));
		}
	}

	@Override
	protected boolean estaAceptadoAlMomento() {
		return true;
	}

	@Override
	protected boolean fueAceptado() {
		return true;
	}

	@Override
	protected double getPorcentajeCompletitud() {
		return (cantidadMuestrasTomadas / cantidadMuestrasNecesarias) * 100;
	}

	
	
}
