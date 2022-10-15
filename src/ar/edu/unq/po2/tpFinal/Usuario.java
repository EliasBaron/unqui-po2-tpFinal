package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Usuario {

	private int cantidadMuestrasPreferida;
	private int dificultadPreferida;
	private int recompensaPreferida;
	private TipoRecomendacion recomendacionPreferida;
	private List<Proyecto> proyectosUsuario;
	private List<Muestra> muestrasUsuario;
	private List<DesafioAceptado> desafiosAceptados;

	public Usuario(int cantidadMuestrasPreferida, int dificultadPreferida, int recompensaPreferida, TipoRecomendacion recomendacionPreferida) {
		this.cantidadMuestrasPreferida = cantidadMuestrasPreferida;
		this.dificultadPreferida = dificultadPreferida;
		this.recompensaPreferida = recompensaPreferida;
		this.recomendacionPreferida = recomendacionPreferida;
	}
	
	public void addMuestra(Muestra muestra) {
		muestrasUsuario.add(muestra);
	}
	
	public void addProyecto(Proyecto proyecto) {
		proyectosUsuario.add(proyecto);
	}
	
	public List<DesafioAceptado> getDesafiosCompletados() {
		//foreach de los desafios retornando los completados
	}
	
	public double getPorcentajeCompletitudUsuario() {
		//foreach con un contador y division?
	}
	
	public double estaCompletoDesafio(DesafioAceptado desafio) {
		// return porcentaje de desafio
	}
	
	public void calificarDesafio(DesafioAceptado desafio, int calificacion) {
		// desafio.recibirCalificacion(calificacion);
	}

}
