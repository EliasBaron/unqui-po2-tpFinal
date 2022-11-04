package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FiltroTest {
	private And filtroAnd;
	private Or filtroOr;
	private Not filtroNot;
	private BusquedaPorCategoria operando1;
	private BusquedaPorTitulo operando2;
	private Proyecto proyecto1;
	private Proyecto proyecto2;
	private Categoria categoria1;
	private Categoria categoria2;
	private List<Categoria> listaCategoria;
	private List<Desafio> desafios;
	
		
	

	@BeforeEach
	void setUp() throws Exception {
		categoria1= new Categoria("Las plantas");
		categoria2=new Categoria("Los Animales");
		listaCategoria= new List;
		operando1= new BusquedaPorCategoria(listaCategoria);
		filtroOr=new Or(operando1,operando2);
		filtroAnd = new And(operando1,operando2);
		filtroNot =new Not(operando1);
		
		
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
