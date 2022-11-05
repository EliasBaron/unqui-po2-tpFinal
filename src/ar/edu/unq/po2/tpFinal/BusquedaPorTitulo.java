package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class BusquedaPorTitulo extends Filtro {
	private String texto;
	
	public BusquedaPorTitulo(String texto) {
		this.texto = texto;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		 return proyectos.stream().filter(proyecto->proyecto.incluyeTextoEnTitulo(texto)).toList();
	}

}
