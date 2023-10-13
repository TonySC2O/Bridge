package Implementacion;

import java.awt.Color;

public interface Filtro {

	boolean filtroActivo();
	void activarFiltro();
	void quitarFiltro();
	String getNombreFiltro();
	void setNombreFiltro(String pNombre);
	Color getColorFiltro();
	void setColorFiltro(Color pColor);
	int getOpacidad();
	void setOpacidad(int pOpacidad);
}
