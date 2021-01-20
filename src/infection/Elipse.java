package infection;

import java.awt.Color;
import java.awt.Graphics;

public class Elipse extends Figura{
	public Elipse(int x, int y, int ancho, int alto, Color color) {
		super(x, y, ancho, alto, color);
	}

	public Elipse(int x, int y, int ancho, int alto, Color color, int incX, int incY) {
		super(x, y, ancho, alto, color, incX, incY);
	}

	public void trazar (Graphics g) {
		g.drawOval (getX(),getY(), getAncho(), getAlto());
	}
	
	public void trazar(Graphics g, int maxX, int maxY) {
		g.drawOval (getX(),getY(), getAncho(), getAlto());

		if (getX()<0 || getY()<0) 
			g.drawOval (maxX + getX(), maxY+getY(), getAncho(), getAlto());
	}

}
