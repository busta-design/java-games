package infection;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguraPanel extends JPanel {
	
	Rectangulo r;
	Cuadrado c;
	Elipse e;
	
	public FiguraPanel(Rectangulo r, Cuadrado c, Elipse e) {
		this.r = r;
		this.c = c;
		this.e = e;
	}

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		r.dibujar(g);
		c.dibujar(g);
		e.dibujar(g);
	}

}
