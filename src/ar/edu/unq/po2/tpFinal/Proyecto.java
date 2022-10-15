package ar.edu.unq.po2.tpFinal;

import java.util.List;

public class Proyecto {
	private String titulo;
	private String descripcion;
	private List<String> categorias;
	private List<Usuario> usuarios;
	private List<Muestra> muestras;

	public Proyecto(String titulo, String descripcion, List<String> categorias) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categorias = categorias;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<String> getCategorias() {
		return categorias;
	}

	public void addUsuario(Usuario usuario) {
		usuarios.add(usuario);

	}

	public List<Muestra> getMuestras() {
		return muestras;
	}

	public void addMuestra(Muestra muestra) {
		muestras.add(muestra);

	}

}
