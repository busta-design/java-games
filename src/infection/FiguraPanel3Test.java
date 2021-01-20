package infection;



import java.awt.Color;
import java.security.SecureRandom;
import javax.swing.JFrame;

public class FiguraPanel3Test {
	//creamos una varibale randomica nAL 
	final static SecureRandom nAl = new SecureRandom();

	public static void main (String[] args) {
		//Cuadrado cuad = new Cuadrado(200, 50, 70, Color.ORANGE, 1, -2);
		
		
		final int TAM = 5;
		final int ANCHO = 500;
		final int ALTO = 500;
		Figura[] fig = new Figura[50];
		final int area = 100;

		boolean colision;
		for (int i=0; i<fig.length; i++) {
			
				System.out.println ("Creando i=" + i);
				colision = false;
				fig[i] = new Cuadrado ( nAl.nextInt ( ANCHO-TAM-1 )+1, nAl.nextInt( ALTO - 15 - TAM-1 ) +1, 
						TAM, Color.RED, nAl.nextInt(2)*2-1, nAl.nextInt(2)*2-1 );
				
		
		} // for
		
		FiguraPanel2 panel = new FiguraPanel2 (fig);
		
		JFrame ventana = new JFrame();
		
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setSize (ANCHO,ALTO);
		ventana.setVisible(true);
		
		while (true) {
			for (Figura f: fig)
				f.moverAcotado( area, area );
				for (Figura f: fig)
					for (Figura g: fig)
						if ( f!=g && f.colision(g) ) {
							f.setIncX (-f.getIncX());
							f.setIncY (-f.getIncY());
							g.setIncX (-g.getIncX());
							g.setIncY (-g.getIncY());
							f.moverAcotado( area, area );
							g.moverAcotado( area, area );
						}
		}
			
		
		
	} // main()

}
