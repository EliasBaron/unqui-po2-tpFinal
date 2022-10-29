package ar.edu.unq.po2.tpFinal;

import java.util.Calendar;
import java.util.Date;

public class RestriccionSemana extends RestriccionTemporal{

	@Override
	public boolean verificar(Date fechaAVerificar) {
		Calendar c = Calendar.getInstance();
		c.setTime(fechaAVerificar);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		return dayOfWeek >= 1 && dayOfWeek <= 5;
	}

}
