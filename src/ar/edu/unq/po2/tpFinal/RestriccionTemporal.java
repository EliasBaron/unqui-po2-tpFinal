package ar.edu.unq.po2.tpFinal;

public class RestriccionTemporal {
	private Date fechaInicio;
	private Date fechaFin;
	private DiaDeSemana dias;

	public RestriccionTemporal(Date fechaInicio, Date fechaFin, DiaDeSemana dias) {
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dias = dias;
	}
	
	public boolean verificarEntreFechas(Muestra muestra) {}
	
	public boolean verificarSemana(Muestra muestra) {}
	
	public boolean verificarFechaYSemana(Muestra muestra) {}

}
