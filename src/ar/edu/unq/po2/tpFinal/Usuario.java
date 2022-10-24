package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;


public class Usuario {

	private int cantidadMuestrasPreferida;
	private int dificultadPreferida;
	private int recompensaPreferida;
//	private TipoRecomendacion recomendacionPreferida;
	private List<Proyecto> proyectosUsuario = new ArrayList<>();
	private List<Muestra> muestrasUsuario = new ArrayList<>();
	private List<DesafioAceptado> desafiosAceptados = new ArrayList<>();

	public Usuario(int cantidadMuestrasPreferida, int dificultadPreferida, int recompensaPreferida) {
		this.cantidadMuestrasPreferida = cantidadMuestrasPreferida;
		this.dificultadPreferida = dificultadPreferida;
		this.recompensaPreferida = recompensaPreferida;
//		this.recomendacionPreferida = recomendacionPreferida;
	}

	public void addMuestra(Muestra muestra) {
		muestrasUsuario.add(muestra);
		this.notificarDesafios(muestra);
	}
	
	public void addProyecto(Proyecto proyecto) {
		proyectosUsuario.add(proyecto);
	}
	
	public int getCantidadMuestrasPreferida() {
		return cantidadMuestrasPreferida;
	}

	public int getDificultadPreferida() {
		return dificultadPreferida;
	}

	public int getRecompensaPreferida() {
		return recompensaPreferida;
	}
	
	public void notificarDesafios(Muestra muestra) {
		for (DesafioAceptado desafio : this.desafiosAceptados) {
			desafio.evaluarMuestra(muestra);
		}
	}

	public void aceptarDesafio(Desafio desafio) {
		if (this.algunProyectoTiene(desafio)) {
			desafiosAceptados.add(new DesafioAceptado(this, desafio));
		}
	}

	private boolean algunProyectoTiene(Desafio desafio) {
		return proyectosUsuario.stream().anyMatch(proyecto -> proyecto.estaDisponible(desafio));
	}



//	public List<DesafioAceptado> getDesafiosCompletados() {
//		//foreach de los desafios retornando los completados
//	}

//	public double getPromedioPorcentajeCompletitud() {
//		//foreach con un contador y division?
//	}

//	public boolean estaCompletoDesafio(DesafioAceptado desafio) {
//
//	}

//	public void calificarDesafio(DesafioAceptado desafio, int calificacion) {
//		// desafio.recibirCalificacion(calificacion);
//	}

	// public DesafioAceptado buscarDesafio(Desafio )
	
	// public List<Desafio> getPreferidos(List<Desafio> desafios){}
	
}
