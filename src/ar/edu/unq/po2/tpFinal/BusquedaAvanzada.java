package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class BusquedaAvanzada extends BuscadorDeProyecto{
	private List<BuscadorDeProyecto> buscadoresDeProyectos;
	

	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		 List<Proyecto> proyectosFiltrados = proyectos;
		for(BuscadorDeProyecto buscador: buscadoresDeProyectos) {
			proyectosFiltrados = buscador.filtrar(proyectosFiltrados);
		}
		return proyectosFiltrados;
	}
	
	public void agregarProyecto(BuscadorDeProyecto buscador) {
		buscadoresDeProyectos.add(buscador);
	}
	
	public void eliminarProyecto(BuscadorDeProyecto buscador) {
		buscadoresDeProyectos.remove(buscador);
	}
	

}
