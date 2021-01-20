package infection;

import java.awt.Color;
import java.security.SecureRandom;
import javax.swing.JFrame;

public class FiguraPanel2Test {
	//creamos una varibale randomica nAL 
	final static SecureRandom nAl = new SecureRandom();

	public static void main (String[] args) {
		
		final int TAM = 10;
		final int ANCHO = 500;
		final int ALTO = 500;
		Figura[] fig = new Figura[100];
		

		boolean colision;
		for (int i=0; i<fig.length; i++) {
			do {
				System.out.println ("Creando i=" + i);
				colision = false;
				fig[i] = new Cuadrado ( nAl.nextInt ( ANCHO-TAM-1 )+1, nAl.nextInt( ALTO - 15 - TAM-1 ) +1, 
						TAM, Color.RED, nAl.nextInt(2)*2-1, nAl.nextInt(2)*2-1 );
				for (int j=0; j<i && !colision ; j++) 
					if ( fig[i].colision (fig[j]) )
						colision = true;
			} while (colision);
		} // for
		
		FiguraPanel2 panel = new FiguraPanel2 (fig);
		
		JFrame ventana = new JFrame();
		
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setSize (ANCHO,ALTO);
		ventana.setVisible(true);

		while (true) {
			for (Figura f: fig)
				f.moverAcotado( panel.getWidth(), panel.getHeight() );
			

			for (Figura f: fig)
				for (Figura g: fig)
					if ( f!=g && f.colision(g) ) {
						f.setIncX (-f.getIncX());
						f.setIncY (-f.getIncY());
						g.setIncX (-g.getIncX());
						g.setIncY (-g.getIncY());
						f.moverAcotado( panel.getWidth(), panel.getHeight() );
						g.moverAcotado( panel.getWidth(), panel.getHeight() );
						
					}

			panel.repaint();
			
			try {  // inicio de retardo
				Thread.sleep(50);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			} // fin del retardo
			
		} // fin 
			
		
		
	} // main()

}
