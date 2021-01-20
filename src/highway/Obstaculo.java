package highway;

import java.awt.Color;
import java.awt.Graphics;

import infection.Rectangulo;

public class Obstaculo  extends Rectangulo{
	
	public Obstaculo(int x, int y ) {
		super(x, y, 20, 20, Color.YELLOW, 0, 3 );
	}
	
	@Override
	public void trazar(Graphics g) {
		g.fillRect ( getX(), getY(), getAncho(), getAlto() );
	}

}
