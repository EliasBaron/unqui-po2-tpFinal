package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class ExclusionPorCategoria extends Filtro{
	
	private List<Categoria> categoriasAIncluir;
	
	
	public ExclusionPorCategoria(List<Categoria> categoriasAIncluir) {
		this.categoriasAIncluir = categoriasAIncluir;
	}


	@Override
	public List<Proyecto> filtrar(List<Proyecto> proyectos) {
		
		return proyectos.stream().filter(proyecto->!proyecto.incluyeCategorias(categoriasAIncluir)).toList();
	}

}
