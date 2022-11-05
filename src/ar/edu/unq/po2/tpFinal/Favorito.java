package ar.edu.unq.po2.tpFinal;

import java.util.Comparator;
import java.util.List;

public class Favorito extends TipoRecomendacion {

	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios) {
		List<Desafio> listaDe20Coincidencia = this.ordenarPorCoincidencia(desafios, usuario).subList(0, 19);
		
		Desafio desafioMasGustadoUsuario = usuario.devolverDesafioMayorPuntaje();
		
		List<Desafio> desafiosOrdenados = listaDe20Coincidencia.stream()
                .sorted(Comparator.comparingInt(d -> this.promedioEntreDesafios(d, desafioMasGustadoUsuario)))
                .limit(5)
                .toList();
		
		
		return desafiosOrdenados;
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {

		return new PreferenciaJuego();
	}

	public int promedioEntreDesafios(Desafio unDesafio, Desafio otroDesafio) {

		return this.sumaDeDistancias(unDesafio, otroDesafio) / 3;
	}

	public int sumaDeDistancias(Desafio unDesafio, Desafio otroDesafio) {
		return this.distanciaEntre(unDesafio.getCantidadDeMuestrasNecesarias(), otroDesafio.getCantidadDeMuestrasNecesarias()) +
				this.distanciaEntre(unDesafio.getRecompensa(), otroDesafio.getRecompensa())
				+ this.distanciaEntre(unDesafio.getDificultad(), otroDesafio.getDificultad());
	}
	
	public int distanciaEntre(int n1, int n2) {
		return Math.abs(n1-n2);
	}

}
