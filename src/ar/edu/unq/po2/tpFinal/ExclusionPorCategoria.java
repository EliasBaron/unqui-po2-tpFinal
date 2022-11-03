package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class ExclusionPorCategoria extends BuscadorDeProyecto{
	
	private List<Categoria> categoriasAIncluir;
	
	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(proyecto->!proyecto.incluyeCategorias(categoriasAIncluir)).toList();
	}

}
