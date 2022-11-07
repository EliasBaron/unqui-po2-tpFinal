package ar.edu.unq.po2.tpFinal;

import java.util.ArrayList;
import java.util.List;

public class Proyecto {
	
	private String titulo;
	private String descripcion;
	private List<Categoria> categorias = new ArrayList<>();
	private List<Desafio> desafiosDisponibles = new ArrayList<>();
	private List<Usuario> usuarios = new ArrayList<>();
	private List<Muestra> muestras = new ArrayList<>();

	public Proyecto(String titulo, String descripcion, List<Categoria> categorias, List<Desafio> desafios) {
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.categorias = categorias;
		this.desafiosDisponibles = desafios;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public List<Categoria> getCategorias() {
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

	public List<Desafio> getDesafiosDisponibles() {
		return desafiosDisponibles;
	}

	public boolean estaDisponible(Desafio desafio) {
		return desafiosDisponibles.contains(desafio);
	}

	public boolean incluyeCategorias(List<Categoria> categorias) {
		return this.getCategorias().containsAll(categorias);
	}

	public boolean incluyeTextoEnTitulo(String texto) {
		return this.getTitulo().contains(texto);
	}
}
