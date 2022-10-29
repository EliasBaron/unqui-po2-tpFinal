package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionFinDeSemanaTest {
	private RestriccionFinDeSemana restriccionFinDeSemana;

	private Date fechaPrueba;

	@BeforeEach
	void setUp() throws Exception {
		restriccionFinDeSemana = new RestriccionFinDeSemana();
	}

	@Test
	void testDiaMiercoles() {
		fechaPrueba = new GregorianCalendar(2022, 10 - 1, 26).getTime();
		assertFalse(restriccionFinDeSemana.verificar(fechaPrueba));
	}

	@Test
	void testDiaSabado() {
		fechaPrueba = new GregorianCalendar(2022, 10 - 1, 29).getTime();
		assertTrue(restriccionFinDeSemana.verificar(fechaPrueba));
	}

}
