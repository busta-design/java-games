package highway;

import java.awt.Color;
import java.awt.Graphics;

import infection.Elipse;

public class Vidas extends Elipse{
	
	

	public Vidas(int x, int y) {
		super(x, y, 10, 10, Color.RED);
	}
	
	@Override
	public void trazar(Graphics g) {
		g.fillOval ( getX(), getY(), getAncho(), getAlto() );
	}
	
	

}
