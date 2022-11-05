package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class PreferenciaJuego extends TipoRecomendacion {

	@Override
	public List<Desafio> recomendar(Usuario usuario, List<Desafio> desafiosAAceptar) {
		
		
		return this.ordenarPorCoincidencia(desafiosAAceptar, usuario).subList(0, 4);
	}

	@Override
	public TipoRecomendacion cambiarRecomendacion() {
		
		return new Favorito();
	}
	
	

}
