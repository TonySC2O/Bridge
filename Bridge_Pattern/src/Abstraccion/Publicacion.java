package Abstraccion;

import java.awt.Color;

import Implementacion.Filtro;

public abstract class Publicacion {
	
	protected Filtro filtro;
	protected String pathphoto;
	
	public Filtro getFiltro() {
		return this.filtro;
	}

	public void setFiltro(Filtro pFiltro) {
		this.filtro = pFiltro;
	}
	
	public String getPathphoto() {
		return pathphoto;
	}

	public void setPathphoto(String pathphoto) {
		this.pathphoto = pathphoto;
	}

	public abstract void onOffFilter();
	public abstract void aumentarOpacidad();
	public abstract void disminuirOpacidad();
	public abstract String getNombreFiltro();
	public abstract Color getColor();
}
