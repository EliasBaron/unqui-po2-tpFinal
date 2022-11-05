package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Favorito extends TipoRecomendacion {

	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios) {
		List<Desafio> listaDe20Coincidencia = this.ordenarPorCoincidencia(desafios, usuario).subList(0, 19);

		return ;
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {

		return new PreferenciaJuego();
	}

	public double promedioEntreDesafios(Desafio unDesafio, Desafio otroDesafio) {

		return this.sumaDeDistancias(unDesafio, otroDesafio) / 3;
	}

	public double sumaDeDistancias(Desafio unDesafio, Desafio otroDesafio) {
		return this.distanciaEntre(unDesafio.getCantidadDeMuestrasNecesarias(), otroDesafio.getCantidadDeMuestrasNecesarias()) +
				this.distanciaEntre(unDesafio.getRecompensa(), otroDesafio.getRecompensa())
				+ this.distanciaEntre(unDesafio.getDificultad(), otroDesafio.getDificultad());
	}
	
	public double distanciaEntre(int n1, int n2) {
		return Math.abs(n1-n2);
	}

}
