package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class TipoRecomendacion {

	public abstract List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios);
	
	public abstract TipoRecomendacion cambiarRecomendacion();
	
	public Integer coincidenciaParaDesafio(Desafio desafio, Usuario usuario) {
		return Integer.valueOf(this.valorEntreNumeros(desafio.getCantidadDeMuestrasNecesarias(), usuario.getCantidadMuestrasPreferida()) 
				+ this.valorEntreNumeros(desafio.getRecompensa(), usuario.getRecompensaPreferida()) 
				+ this.valorEntreNumeros(desafio.getDificultad(), usuario.getDificultadPreferida()));
	}
	
	public int valorEntreNumeros(int n1, int n2) {
		return Math.abs(n1 - n2);
	}
	
//	public List<Desafio> ordenarPorCoincidencia(List<Desafio> desafios, Usuario usuario){
//		
//
//		List<Desafio> listaFiltradaSorteada = usuario.excluirDesafiosAceptados(desafios);
//		List<Desafio> listaFinal = new ArrayList<>();
//		
//		Collections.sort(listaFiltradaSorteada, (d1,d2) -> this.coincidenciaParaDesafio(d1, usuario).compareTo(this.coincidenciaParaDesafio(d2, usuario)));
//		
//		for(Desafio desafio : listaFiltradaSorteada) {
//			listaFinal.add(desafio);
//		}
//		
//		return listaFinal;
//		
//	}
	
	public List<Desafio> ordenarPorCoincidencia(List<Desafio> desafios, Usuario usuario){
		List<Desafio> desafiosCoincidencia = desafios.stream().sorted(Comparator.comparingInt(d -> this.coincidenciaParaDesafio(d, usuario))).toList();
		
		return desafiosCoincidencia;
	}
}
