package infection;

import java.security.SecureRandom;
import javax.swing.JFrame;

public class InfectionMainTest {


		//creamos una varibale randomica nAL 
		final static SecureRandom nAl = new SecureRandom();

		public static void main (String[] args) {
			
			final int TAM = 15;
			final int ANCHO = 500;
			final int ALTO = 500;
			int contador = 0; 
			final int AREA = 200;
			final int MOVANCHO = 50;
			final int MOVALTO = 50;
			Sujeto[] fig = new Sujeto[100];
			//Sujeto[] recu = new Sujeto[10];

			boolean colision;
			for (int i=0; i<fig.length; i++) {
				fig[i] = new Sujeto( TAM, ANCHO, ALTO, MOVANCHO, MOVALTO );
				do {
					System.out.println ("Verificando i=" + i);
					colision = false;
					for (int j=0; j<i && !colision ; j++) 
						if ( fig[i].colision (fig[j]) ) {
							colision = true;
							fig[i].calcularPosicion(ANCHO, ALTO, MOVANCHO, MOVALTO);
						}	
				} while (colision);
			} // for
			fig[0].setContagiado(true);
			FiguraPanel2 panel = new FiguraPanel2 (fig);
			
			JFrame ventana = new JFrame();
			
			ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
			ventana.add(panel);
			ventana.setSize (ANCHO,ALTO);
			ventana.setVisible(true);

			while (true) {
				for (Sujeto f: fig) {
					f.moverAcotado2();
					f.recuperacion();
				}
			

				for (Sujeto f: fig)
					for (Sujeto g: fig)
						if ( f!=g && f.colision(g) ) {
							//f.setColor(f.getColor);
							f.setIncX (-f.getIncX());
							f.setIncY (-f.getIncY());
							g.setIncX (-g.getIncX());
							g.setIncY (-g.getIncY());
							f.moverAcotado( panel.getWidth(), panel.getHeight() );
							g.moverAcotado( panel.getWidth(), panel.getHeight() );
							
							if (f.isContagiado()||g.isContagiado())
							{
								
								f.setContagiado(true); 
								g.setContagiado(true);
								//f.setContador();
							}	
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



