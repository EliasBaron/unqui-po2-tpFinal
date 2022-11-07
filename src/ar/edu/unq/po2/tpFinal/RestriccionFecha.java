package ar.edu.unq.po2.tpFinal;

import java.util.Date;

public class RestriccionFecha extends RestriccionTemporal {
	
	private Date fechaInicio;
	private Date fechafin;

	public RestriccionFecha(Date fechaInicio, Date fechafin) {
		this.fechaInicio = fechaInicio;
		this.fechafin = fechafin;
	}

	@Override
	public boolean verificar(Date fechaAVerificar) {
		return ((fechaAVerificar.after(fechaInicio) || fechaAVerificar.equals(fechaInicio))
				&& (fechaAVerificar.before(fechafin) || fechaAVerificar.equals(fechafin)));
	}
}
