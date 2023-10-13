package Implementacion;

import java.awt.Color;

public class FiltroRojo implements Filtro{

	private boolean activo = true;
	private String nombreFiltro = "Filtro Rojo";
	private int opacidad = 10;
	private int[] rgb = {255, 0, 0};
	private Color colorFiltro = new Color(rgb[0], rgb[1], rgb[2], opacidad);
	
	@Override
	public boolean filtroActivo() {
		// TODO Auto-generated method stub
		return activo;
	}
	@Override
	public void activarFiltro() {
		// TODO Auto-generated method stub
		activo = true;
	}
	@Override
	public void quitarFiltro() {
		// TODO Auto-generated method stub
		activo = false;
	}
	@Override
	public String getNombreFiltro() {
		// TODO Auto-generated method stub
		return nombreFiltro;
	}
	@Override
	public void setNombreFiltro(String pNombre) {
		// TODO Auto-generated method stub
		this.nombreFiltro = pNombre;
		
	}
	@Override
	public Color getColorFiltro() {
		// TODO Auto-generated method stub
		return colorFiltro;
	}
	@Override
	public void setColorFiltro(Color pColor) {
		// TODO Auto-generated method stub}
		this.colorFiltro = pColor;
		this.rgb[0] = pColor.getRed();
		this.rgb[1] = pColor.getGreen();
		this.rgb[2] = pColor.getBlue();
	}
	@Override
	public int getOpacidad() {
		// TODO Auto-generated method stub
		return opacidad;
	}
	@Override
	public void setOpacidad(int pOpacidad) {
		// TODO Auto-generated method stub
		this.opacidad = pOpacidad;
		this.colorFiltro = new Color(rgb[0], rgb[1], rgb[2], opacidad);
	}
}