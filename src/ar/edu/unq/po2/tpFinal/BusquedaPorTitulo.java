package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class BusquedaPorTitulo extends BuscadorDeProyecto {
	private String texto;
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		 return proyectos.stream().filter(proyecto->proyecto.incluyeTextoEnTitulo(texto)).toList();
	}

}
