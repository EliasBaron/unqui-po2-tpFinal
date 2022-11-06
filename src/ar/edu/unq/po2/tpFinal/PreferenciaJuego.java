package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class PreferenciaJuego extends TipoRecomendacion {
	
	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafiosAAceptar) {
		
		List<Desafio> desafiosOrdenados = this.ordenarPorCoincidencia(desafiosAAceptar, usuario);
		
		return desafiosOrdenados.stream().limit(5).toList();
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {
		
		return new Favorito();
	}
	
}
