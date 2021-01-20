package infection;
import java.awt.Color;
import java.awt.Graphics;

public class Rectangulo extends Figura  {
	public Rectangulo(int x, int y, int ancho, int alto, int i, int j, Color color) {
		super(x, y, ancho, alto, color);
	}
	
	public Rectangulo(int x, int y, int ancho, int alto, Color color, int incX, int incY) {
		super(x, y, ancho, alto, color, incX, incY);
	}

	public Rectangulo(int x, int y, int i, int j, Color gray) {
		super(x, y, i, j, gray);
	}

	public void trazar (Graphics g) {
		g.drawRect (getX(),getY(), getAncho(), getAlto());
	}
	
	public void trazar(Graphics g, int maxX, int maxY) {
		g.drawRect (getX(),getY(), getAncho(), getAlto());

		if (getX()<0 || getY()<0) 
			g.drawRect (maxX + getX(), maxY+getY(), getAncho(), getAlto());
	}

}
