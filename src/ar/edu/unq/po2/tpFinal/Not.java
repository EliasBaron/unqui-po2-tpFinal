package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Not extends Filtro {
	private Filtro operando;

	public Not(Filtro operando) {
		this.operando = operando;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> lista) {

		List<Proyecto> listaFiltrada = operando.filtrar(lista);

		return lista.stream().filter(proyecto -> !listaFiltrada.contains(proyecto)).toList();
	}

}
