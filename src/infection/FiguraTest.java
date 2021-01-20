package infection;

import java.awt.Color;

import javax.swing.JFrame;

public class FiguraTest {
	public static void main (String[] args) {
		Rectangulo r = new Rectangulo(50, 50, 100, 50, Color.RED);
		Cuadrado cuad = new Cuadrado(200, 50, 70, Color.ORANGE);
		Elipse elipse = new Elipse(200, 150, 70, 35, Color.GREEN);
		
		System.out.println (r);
		System.out.println (cuad);
		
		FiguraPanel panel = new FiguraPanel (r, cuad, elipse);
		//FiguraPanel panel = new FiguraPanel (r);
		
		JFrame ventana = new JFrame();
		
		ventana.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		ventana.add(panel);
		ventana.setSize (500,500);
		ventana.setVisible(true);
		
		
	}

}
