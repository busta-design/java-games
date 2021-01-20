package infection;

import java.awt.Color;
import java.awt.Graphics;

public class Triangulo extends Figura{
	public Triangulo(int x, int y, int ancho, int alto, Color color) {
		super(x, y, ancho, alto, color);
	}
	public Triangulo(int x, int y, int ancho, int alto, Color color, int incX, int incY) {
		super(x, y, ancho, alto, color, incX, incY);
	}

	@Override
	public void trazar(Graphics g) {
		g.drawLine (getX(),getY(), getX()+getAncho(), getY());
		g.drawLine(getX()+getAncho(), getY(), (getX()+(getAncho()/2)), getY()-getAlto());
		g.drawLine(getX()+(getAncho()/2), getY()-getAlto(), getX(), getY());
		
	}
	@Override
	public void trazar(Graphics g, int maxX, int maxY) {
		// TODO Auto-generated method stub
		
	}

	

}
