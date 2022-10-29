package ar.edu.unq.po2.tpFinal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RestriccionSemanaTest {
	private RestriccionSemana restriccionSemana;

	private Date fechaPrueba;

	@BeforeEach
	void setUp() throws Exception {
		restriccionSemana = new RestriccionSemana();
	}

	@Test
	void testDiaMiercoles() {
		fechaPrueba = new GregorianCalendar(2022, 10 - 1, 26).getTime();
		assertTrue(restriccionSemana.verificar(fechaPrueba));
	}

	@Test
	void testDiaSabado() {
		fechaPrueba = new GregorianCalendar(2022, 10 - 1, 29).getTime();
		assertFalse(restriccionSemana.verificar(fechaPrueba));
	}
}
