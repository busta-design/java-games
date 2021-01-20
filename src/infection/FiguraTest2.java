package infection;
import java.awt.Color;

import javax.swing.JFrame;

public class FiguraTest2 {
	public static void main (String[] args) {
		// las ultimas coordenadas son como se van a mover, en x(1 es abajo, -1 arriba, y 1 derecha, y-1 izquierda) y
		Rectangulo r = new Rectangulo(50, 50, 100, 50, Color.RED, 1, 1);
		Cuadrado cuad = new Cuadrado(200, 50, 70, Color.ORANGE, 0, -1);
		Elipse elipse = new Elipse(200, 150, 70, 35, Color.GREEN, -1, 1);
		
		//System.out.println (r);
		//System.out.println (cuad);
		
		FiguraPanel panel = new FiguraPanel (r, cuad, elipse);
		
		JFrame ventana = new JFrame();
		
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setSize (300,300);
		ventana.setVisible(true);
		
		for (int i=0; i<1000; i++) {
			//necesitamos el tama�o del panel por eso pedimos width el alto y height el largo
			r.moverAcotado( panel.getWidth(), panel.getHeight() );
			elipse.moverAcotado( panel.getWidth(), panel.getHeight() );
			cuad.moverContinuo( panel.getWidth(), panel.getHeight() );
			
			//le decimos al panel que va a volver a ser dibujado si o si necesitamos para que se dibujen varios 
			panel.repaint();
			
			try {  // inicio de retardo
				Thread.sleep(50);
			} catch(InterruptedException ex) {
				Thread.currentThread().interrupt();
			} // fin del retardo
		}
			
		
		
	}
	}
