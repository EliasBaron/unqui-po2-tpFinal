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

	public TipoRecomendacion getRecomendacionPreferida() {
		return recomendacionPreferida;
	}

	public List<Proyecto> getProyectosUsuario() {
		return proyectosUsuario;
	}

	public List<Muestra> getMuestrasUsuario() {
		return muestrasUsuario;
	}

	public List<DesafioUsuario> getDesafiosUsuario() {
		return desafiosUsuario;
	}

	public void addMuestra(Muestra muestra) {
		muestrasUsuario.add(muestra);
		this.notificarDesafios(muestra);
	}

	public void addProyecto(Proyecto proyecto) {
		if(!proyectosUsuario.contains(proyecto)) {
			proyectosUsuario.add(proyecto);
			proyecto.addUsuario(this);
		}
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

	public List<DesafioUsuario> getDesafiosUsuarioAceptados() {
		return desafiosUsuario.stream().filter(desafio -> desafio.estaAceptadoAlMomento()).toList();
	}

	public void notificarDesafios(Muestra muestra) {
		for (DesafioUsuario desafio : this.desafiosUsuario) {
			desafio.evaluarMuestra(muestra);
		}
	}
	
	public void addDesafioPorAceptar(Desafio desafio) {
		desafiosUsuario.add(new DesafioUsuario(desafio));
	}

	public void aceptarDesafio(DesafioUsuario desafioUsuario) {
		if (this.algunProyectoTiene(desafioUsuario.getDesafio()) && !desafioUsuario.fueAceptadoPreviamente()) {
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
		List<Desafio> desafiosAceptados = this.getDesafiosUsuarioAceptados().stream()
				.map(desafioUsuario -> desafioUsuario.getDesafio()).toList();

		return desafiosAAceptar.stream().filter(desafio -> !desafiosAceptados.contains(desafio)).toList();
	}

	public boolean estaCompletoDesafio(DesafioUsuario desafioUsuario) {
		return desafiosUsuario.get(desafiosUsuario.indexOf(desafioUsuario)).getEstaCompleto();
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
	
	public void setDesafiosUsuario(List<DesafioUsuario> desafiosUsuario) {
		this.desafiosUsuario = desafiosUsuario;     //METODO UNICAMENTE PARA LOS TESTS YA QUE NO HAY UN SET
													//DE DESAFIO USUARIO, SOLAMENTE SE AGREGAN COMO DESAFIO
													//PERO SE TRANSFORMAN EN OTRA CLASE Y DA PROBLEMAS.
	}
	

}
