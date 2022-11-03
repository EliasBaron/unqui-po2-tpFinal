package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class BusquedaPorCategoria extends BuscadorDeProyecto{


	private List<Categoria> categoriasAIncluir;
	
	public BusquedaPorCategoria(List<Categoria> categoriasAIncluir) {
		this.categoriasAIncluir = categoriasAIncluir;
	}


	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(proyecto->proyecto.incluyeCategorias(categoriasAIncluir)).toList();
	}

}
