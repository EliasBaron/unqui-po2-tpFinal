package ar.edu.unq.po2.tpFinal;

//import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Or extends Filtro {

	private Filtro operando1;
	private Filtro operando2;

	public Or(Filtro operando1, Filtro operando2) {
		
		this.operando1 = operando1;
		this.operando2 = operando2;
	}

	@Override
	public List<Proyecto> filtrar(List<Proyecto> lista) {

		List<Proyecto> listaFiltrada1 = operando1.filtrar(lista);
		List<Proyecto> listaFiltrada2 = operando2.filtrar(lista);
		
		return Stream.concat(listaFiltrada1.stream(),listaFiltrada2.stream()).toList();
	}

}
