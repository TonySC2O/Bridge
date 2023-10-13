package Main;

import java.util.ArrayList;

import GUI.Ventana;
import Abstraccion.*;
import Implementacion.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
		
		publicaciones.add(new PublicacionRodrigo(new FiltroRojo()));
		publicaciones.add(new PublicacionTony(new FiltroAzul()));
		
		Ventana v1 = new Ventana(publicaciones);
		
		v1.setVisible(true);
	}

}
