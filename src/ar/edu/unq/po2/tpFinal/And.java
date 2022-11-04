package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class And extends Filtro {

	private Filtro operando1;
	private Filtro operando2;

	public And(Filtro operando1, Filtro operando2) {
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> lista) {
		
		List<Proyecto> listaFiltrada1 = operando1.filtrar(lista);
		List<Proyecto> listaFiltrada2 = operando2.filtrar(lista);
		
		return listaFiltrada1.stream().filter(proyecto -> listaFiltrada2.contains(proyecto)).toList();
	}

}
