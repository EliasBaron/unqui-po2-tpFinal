package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class PreferenciaJuego extends TipoRecomendacion {

	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios) {
		// TODO Auto-generated method stub
		return this.ordenarPorCoincidencia(desafios, usuario).subList(0, 4);
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {
		// TODO Auto-generated method stub
		return null;
	}

}
