package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class TipoRecomendacion {

	public abstract List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios);
	
	public abstract TipoRecomendacion cambiarRecomendacion();
	
	public Integer coincidenciaParaDesafio(Desafio desafio, Usuario usuario) {
		return Integer.valueOf(this.valorCantidadDeMuestras(desafio, usuario) + this.valorRecompensa(desafio, usuario) + this.valorDificultad(desafio, usuario));
	}
	
	public int valorCantidadDeMuestras(Desafio desafio, Usuario usuario) {
		return Math.abs(desafio.getCantidadDeMuestrasNecesarias() - usuario.getCantidadMuestrasPreferida());
	}
	
	public int valorRecompensa(Desafio desafio, Usuario usuario) {
		return Math.abs(desafio.getRecompensa() - usuario.getRecompensaPreferida());
	}
	
	public int valorDificultad(Desafio desafio, Usuario usuario) {
		return Math.abs(desafio.getDificultad() - usuario.getDificultadPreferida());
	}
	
	public List<Desafio> ordenarPorCoincidencia(List<Desafio> desafios, Usuario usuario){
		
//		return Collections.sort(desafios,(d1,d2) -> (Integer.valueOf(this.coincidenciaParaDesafio(d1, usuario)).compareTo((Integer.valueOf(this.coincidenciaParaDesafio(d2, usuario))))));
		List<Desafio> listaSorteada = desafios;
		List<Desafio> listaFinal = new ArrayList<>();
		
		Collections.sort(listaSorteada, (d1,d2) -> this.coincidenciaParaDesafio(d1, usuario).compareTo(this.coincidenciaParaDesafio(d2, usuario)));
		
		for(Desafio desafio : listaSorteada) {
			listaFinal.add(desafio);
		}
		
		return listaFinal;
		
	}
}