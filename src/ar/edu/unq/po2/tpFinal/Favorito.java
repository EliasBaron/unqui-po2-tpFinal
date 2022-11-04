package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Favorito extends TipoRecomendacion {

	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafios) {
		
		return ;
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {
		
		return new PreferenciaJuego();
	}

}
