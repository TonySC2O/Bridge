package Abstraccion;

import java.awt.Color;

import Implementacion.Filtro;

public class PublicacionRodrigo extends Publicacion{

    public PublicacionRodrigo(Filtro pFiltro)
    {
        this.setFiltro(pFiltro);
        this.setPathphoto("/Images/Rodrigo.jpg");
    }

	@Override
	public void onOffFilter() {
		// TODO Auto-generated method stub
		if(filtro.filtroActivo()) {
			filtro.quitarFiltro();
		}else {
			filtro.activarFiltro();
		}
	}

	@Override
	public void aumentarOpacidad() {
		// TODO Auto-generated method stub
		if(filtro.getOpacidad() < 250) {
			filtro.setOpacidad(filtro.getOpacidad()+10);
		}
	}

	@Override
	public void disminuirOpacidad() {
		// TODO Auto-generated method stub
		if(filtro.getOpacidad() > 10) {
			filtro.setOpacidad(filtro.getOpacidad()-10);
		}
	}

	@Override
	public String getNombreFiltro() {
		// TODO Auto-generated method stub
		return filtro.getNombreFiltro();
	}

	@Override
	public Color getColor() {
		// TODO Auto-generated method stub
		return filtro.getColorFiltro();
	}
	
}
