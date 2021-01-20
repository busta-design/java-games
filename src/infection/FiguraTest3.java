package infection;

import java.awt.Color;

import javax.swing.JFrame;

public class FiguraTest3 {
	public static void main (String[] args) {
		Rectangulo r = new Rectangulo(50, 50, 100, 50, Color.RED, 2, 1);
		Cuadrado cuad = new Cuadrado(200, 50, 70, Color.ORANGE, 1, -2);
		Elipse elipse = new Elipse(200, 150, 70, 35, Color.GREEN, -1, 1);
		
		System.out.println (r);
		System.out.println (cuad);
		
		FiguraPanel panel = new FiguraPanel (r, cuad, elipse);
		
		JFrame ventana = new JFrame();
		
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setSize (300,300);
		ventana.setVisible(true);
		
		for (int i=0; i<1000; i++) {
			r.moverAcotado( panel.getWidth(), panel.getHeight() );
			elipse.moverAcotado( panel.getWidth(), panel.getHeight() );
			cuad.moverAcotado( panel.getWidth(), panel.getHeight() );
			
			//rebota a los lados
			if (r.colision(cuad)) {
				r.setIncX (-r.getIncX());
				r.setIncY (-r.getIncY());
				cuad.setIncX (-cuad.getIncX());
				cuad.setIncY (-cuad.getIncY());
				r.moverAcotado( panel.getWidth(), panel.getHeight() );
				cuad.moverAcotado( panel.getWidth(), panel.getHeight() );
			}
			
			

			panel.repaint();
			
			try {  // inicio de retardo
				Thread.sleep(50);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			} // fin del retardo
			
		} // fin for
			
		
		
	} // main()

	

}
