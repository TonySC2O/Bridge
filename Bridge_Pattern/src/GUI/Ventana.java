package GUI;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.border.MatteBorder;

import Abstraccion.Publicacion;

import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

public class Ventana extends JFrame {
	
	private ArrayList<Publicacion> publicaciones = new ArrayList<Publicacion>();
	private int indexPublicacion = 0;
	private MatteBorder borde = new MatteBorder(2, 2, 2, 2, Color.WHITE);
	
	private void Colocar_label(JLabel pLabel, JPanel pPanel, int x, int y, int h, int w, boolean pOpacity, 
							   Color pFondo, Color pColorFont, int pTamaño, boolean pBorde, String pFont) {
		pLabel.setFont(new Font(pFont, Font.BOLD, pTamaño)); // Set font and sizO
		pLabel.setForeground(pColorFont); // Set text color
		pLabel.setBackground(pFondo); // Set text color
		pLabel.setHorizontalAlignment(SwingConstants.CENTER);
		if(pBorde == true) {pLabel.setBorder(borde);}
		pLabel.setOpaque(pOpacity);
		pLabel.setBounds(x, y, h ,w);
        if (pPanel != null) {pPanel.add(pLabel);}
	}
	
	private void Colocar_panel(JPanel pPanel, int x, int y, int h, int w, Color pFondo) {
		pPanel.setLayout(null);
		pPanel.setBackground(pFondo);
		pPanel.setBounds(x, y, h, w);
		pPanel.setBorder(borde);
        getContentPane().add(pPanel);
	}
	
	private ImageIcon getImagen(int x, int y) {
		return new ImageIcon(new ImageIcon(getClass().getResource(publicaciones.get(indexPublicacion).getPathphoto())).getImage().getScaledInstance(x, y, Image.SCALE_DEFAULT));
	}
	
	public Ventana(ArrayList<Publicacion> pPublicaciones) {
		
		this.publicaciones = pPublicaciones;
		
		setTitle("Filter Editor");
        setSize(400, 500); // Set the desired size
        setResizable(false); // Disable frame resizing
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(50, 60);
        
        getContentPane().setBackground(Color.BLACK);
        getContentPane().setLayout(null);
        
        JLabel label = new JLabel("Instagram");
        Colocar_label(label, null, 5, 5, 100, 30, false, Color.WHITE, Color.WHITE, 18, false, "Tahoma");
        getContentPane().add(label);
        
        JPanel pnlImage = new JPanel();
        pnlImage.setBounds(40, 60, 300 ,300);
        pnlImage.setLayout(null);
        getContentPane().add(pnlImage);
		
        JLabel lblFiltro = new JLabel();
        lblFiltro.setSize(300, 300);
        lblFiltro.setOpaque(true);
        lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
        pnlImage.add(lblFiltro);
        
        JLabel lblImagen = new JLabel();
        lblImagen.setSize(300 ,300);
        lblImagen.setOpaque(true);
        lblImagen.setBorder(borde);
        lblImagen.setIcon(getImagen(lblImagen.getWidth(), lblImagen.getHeight()));
        pnlImage.add(lblImagen);

        JLabel lblOnOff = new JLabel("Filtro");
        Colocar_label(lblOnOff, null, 45, 360, 50, 50, false, Color.WHITE, Color.WHITE, 15, false, "Tahoma");
        getContentPane().add(lblOnOff);
        
        JButton btnOnOff = new JButton("ON/OFF");
        btnOnOff.setBounds(40, 400, 60, 50);
        btnOnOff.setFocusable(false);
        btnOnOff.setForeground(Color.WHITE);
        btnOnOff.setBackground(Color.BLACK);
        btnOnOff.setBorder(borde);
        btnOnOff.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btnOnOff.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  
        		  	publicaciones.get(indexPublicacion).onOffFilter();
        		  	lblFiltro.setOpaque(true);
        		  	lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
        		  	lblFiltro.setOpaque(false);
        		    if(publicaciones.get(indexPublicacion).getFiltro().filtroActivo()) {
        		    	lblFiltro.setOpaque(true);
        		    }
        		    paint(getGraphics());
        		  } 
        		} );
        
		getContentPane().add(btnOnOff);
		
        JLabel lblOpacidad = new JLabel("Opacidad");
        Colocar_label(lblOpacidad, null, 120, 360, 100, 50, false, Color.WHITE, Color.WHITE, 15, false, "Tahoma");
        getContentPane().add(lblOpacidad);
        
        JButton btnOpUp = new JButton("+");
        btnOpUp.setBounds(135, 400, 35, 50);
        btnOpUp.setFocusable(false);
        btnOpUp.setForeground(Color.WHITE);
        btnOpUp.setBackground(Color.BLACK);
        btnOpUp.setBorder(borde);
        btnOpUp.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
		btnOpUp.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  	if(publicaciones.get(indexPublicacion).getFiltro().filtroActivo()) {
	  	        		
	        		  	publicaciones.get(indexPublicacion).aumentarOpacidad();
	      		  		lblFiltro.setVisible(false);
	      		  		lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
	      		  		lblFiltro.setVisible(true);
        		  	}
        		  } 
        		} );
		getContentPane().add(btnOpUp);
		
        JButton btnOpDown = new JButton("-");
        btnOpDown.setBounds(175, 400, 35, 50);
        btnOpDown.setFocusable(false);
        btnOpDown.setForeground(Color.WHITE);
        btnOpDown.setBackground(Color.BLACK);
        btnOpDown.setBorder(borde);
        btnOpDown.setCursor(new Cursor(Cursor.HAND_CURSOR));

        btnOpDown.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  if(publicaciones.get(indexPublicacion).getFiltro().filtroActivo()) {
        			  publicaciones.get(indexPublicacion).disminuirOpacidad();
        			  lblFiltro.setVisible(false);
        			  lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
        			  lblFiltro.setVisible(true);
        		  }
        	  } 
        } );
		
		getContentPane().add(btnOpDown);
        
        JLabel lblNombre = new JLabel("Nombre Filtro");
        Colocar_label(lblNombre, null, 210, 360, 150, 50, false, Color.WHITE, Color.WHITE, 15, false, "Tahoma");
        getContentPane().add(lblNombre);
        
        JLabel lblNomFiltro = new JLabel(publicaciones.get(indexPublicacion).getNombreFiltro());
        Colocar_label(lblNomFiltro, null, 210, 400, 150, 50, false, Color.WHITE, Color.WHITE, 12, false, "Tahoma");
        getContentPane().add(lblNomFiltro);
        
        JButton btnAnterior = new JButton();
        btnAnterior.setBounds(5, 60, 30, 300);
        btnAnterior.setFocusable(false);
        btnAnterior.setBackground(Color.BLACK);
        btnAnterior.setBorderPainted(false);
        btnAnterior.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAnterior.setContentAreaFilled(false);
        getContentPane().add(btnAnterior);
        
        btnAnterior.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
      		  		indexPublicacion--;
      		  		if(indexPublicacion < 0) {
      		  			indexPublicacion = publicaciones.size()-1;
      		  		}
      		  		lblImagen.setIcon(getImagen(lblImagen.getWidth(), lblImagen.getHeight()));
      		  		lblNomFiltro.setText(publicaciones.get(indexPublicacion).getNombreFiltro());
	      		  	lblFiltro.setVisible(false);
	  		  		lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
	  		  		publicaciones.get(indexPublicacion).getFiltro().quitarFiltro();
        	  } 
        } );

        JButton btnSiguiente = new JButton();
        btnSiguiente.setBounds(345, 60, 35, 300);
        btnSiguiente.setFocusable(false);
        btnSiguiente.setOpaque(true);
        btnSiguiente.setBackground(Color.BLACK);
        btnSiguiente.setBorderPainted(false);
        btnSiguiente.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnSiguiente.setContentAreaFilled(false);
        btnSiguiente.setBorder(borde);
        getContentPane().add(btnSiguiente);
        

        btnSiguiente.addActionListener(new ActionListener() { 
        	  public void actionPerformed(ActionEvent e) { 
        		  	indexPublicacion++;
    		  		if(indexPublicacion == publicaciones.size()) {
    		  			indexPublicacion = 0;
    		  		}
    		  		lblImagen.setIcon(getImagen(lblImagen.getWidth(), lblImagen.getHeight()));
    		  		lblNomFiltro.setText(publicaciones.get(indexPublicacion).getNombreFiltro());
      		  		lblFiltro.setVisible(false);
      		  		lblFiltro.setBackground(publicaciones.get(indexPublicacion).getFiltro().getColorFiltro());
      		  		publicaciones.get(indexPublicacion).getFiltro().quitarFiltro();
        	  } 
        } );
        
        btnOnOff.doClick();
        
        setLocationRelativeTo(null);
    }
	
}
