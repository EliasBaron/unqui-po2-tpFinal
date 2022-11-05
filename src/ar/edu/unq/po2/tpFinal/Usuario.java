package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Usuario {

	private int cantidadMuestrasPreferida;
	private int dificultadPreferida;
	private int recompensaPreferida;
	private TipoRecomendacion recomendacionPreferida;
	private List<Proyecto> proyectosUsuario = new ArrayList<>();
	private List<Muestra> muestrasUsuario = new ArrayList<>();
	private List<DesafioUsuario> desafiosUsuario = new ArrayList<>();

	public Usuario(int cantidadMuestrasPreferida, int dificultadPreferida, int recompensaPreferida,
			TipoRecomendacion recomendacionPreferida) {
		this.cantidadMuestrasPreferida = cantidadMuestrasPreferida;
		this.dificultadPreferida = dificultadPreferida;
		this.recompensaPreferida = recompensaPreferida;
		this.recomendacionPreferida = recomendacionPreferida;
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

	public List<DesafioUsuario> desafiosUsuarioAceptados() {
		return desafiosUsuario.stream().filter(desafio -> desafio.estaAceptadoAlMomento()).toList();
	}

	public void notificarDesafios(Muestra muestra) {
		for (DesafioUsuario desafio : this.desafiosUsuario) {
			desafio.evaluarMuestra(muestra);
		}
	}

	public void aceptarDesafio(DesafioUsuario desafioUsuario) {
		if (this.algunProyectoTiene(desafioUsuario.getDesafio())) {
			desafiosUsuario.get(desafiosUsuario.indexOf(desafioUsuario)).serAceptado();
		}
	}

	private boolean algunProyectoTiene(Desafio desafio) {
		return proyectosUsuario.stream().anyMatch(proyecto -> proyecto.estaDisponible(desafio));
	}

	public List<DesafioUsuario> getDesafiosCompletos() {

		return desafiosUsuario.stream().filter(desafio -> desafio.getEstaCompleto()).toList();
	}

	public double getPromedioPorcentajeCompletitud() {

		List<DesafioUsuario> desafiosCompletos = this.getDesafiosCompletos();

		return (desafiosCompletos.size() / desafiosUsuario.size()) * 100;

	}

	public List<Desafio> excluirDesafiosAceptados(List<Desafio> desafiosAAceptar) {
		List<Desafio> desafiosAceptados = this.desafiosUsuarioAceptados().stream()
				.map(desafioUsuario -> desafioUsuario.getDesafio()).toList();

		return desafiosAAceptar.stream().filter(desafio -> !desafiosAceptados.contains(desafio)).toList();
	}

	public void estaCompletoDesafio(DesafioUsuario desafioUsuario) {
		if (desafiosUsuario.get(desafiosUsuario.indexOf(desafioUsuario)).getEstaCompleto()) {
			desafioUsuario.getEstaCompleto();
		}
		else desafioUsuario.getPorcentajeCompletitud();
	}

	public void calificarDesafio(DesafioUsuario desafioUsuario, int calificacion) {
		desafiosUsuario.get(desafiosUsuario.indexOf(desafioUsuario)).recibirCalificacion(calificacion);
	}

	public Date fechaSuperacionDesafio(DesafioUsuario desafioUsuario) {
		return desafiosUsuario.get(desafiosUsuario.indexOf(desafioUsuario)).getMomentoSuperacion();
	}
	
	public Desafio devolverDesafioMayorPuntaje() {
		List<DesafioUsuario> desafiosCompletados = this.getDesafiosCompletos();
		DesafioUsuario desafioUsuarioMasGustado = desafiosCompletados.get(0);
		
		
		for (int i = 1; i < desafiosCompletados.size(); i++) {
			if(desafiosCompletados.get(i).getCalificacion()>desafioUsuarioMasGustado.getCalificacion()) {
				desafioUsuarioMasGustado=desafiosCompletados.get(i);
			}
			
		}
		return desafioUsuarioMasGustado.getDesafio();
	}
	
	public void recibirRecomendaciones(List<Desafio> desafios) {
		List<Desafio> desafiosRecomendados = recomendacionPreferida.recomendar(this, desafios);
		
		for(Desafio desafio : desafiosRecomendados) {
			desafiosUsuario.add(new DesafioUsuario(desafio));
		}
	}
	
	public void cambiarTipoRecomendacion() {
		this.recomendacionPreferida = recomendacionPreferida.cambiarRecomendacion();
	}
	

}
