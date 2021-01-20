package infection;

import java.awt.Color;

import java.awt.Graphics;

public abstract class Figura {
	private int x,y;
	private int ancho, alto;
	private Color color;
	private int incX, incY;
	private int score;
	

	public Figura  (int x, int y, int ancho, int alto, Color color) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		incX = incY = 0;
		
	}
	

	public Figura(int x, int y, int ancho, int alto, Color color, int incX, int incY) {
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.color = color;
		this.incX = incX;
		this.incY = incY;
	}
	public Figura(int x, int y, int score, Color color) {
		this.x=x;
		this.y=y;
		this.score = score;
		this.color = color;
		
	}
	
	


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getIncX() {
		return incX;
	}

	public void setIncX(int incX) {
		this.incX = incX;
	}

	public int getIncY() {
		return incY;
	}

	public void setIncY(int incY) {
		this.incY = incY;
	}

	@Override
	public String toString() {
		return "Figura [x=" + x + ", y=" + y + ", ancho=" + ancho + ", alto=" + alto + ", color=" + color + ", incX="
				+ incX + ", incY=" + incY + "]";
	}
	
	public void dibujar (Graphics g) {
		//super.paint(g);
		g.setColor (color);
		trazar(g);
	}
	
	public void dibujar (Graphics g, int maxX, int maxY) {
		//super.paint(g);
		g.setColor (color);
		trazar(g, maxX, maxY);
	}
	
	public abstract void trazar (Graphics g);
	public abstract void trazar (Graphics g, int maxX, int maxY);

	public void moverSimple () {
		x = x + incX;
		y = y + incY;
	}
	// creo que es para dar la vuelta 
	public void moverAcotado (int maxX, int maxY ) {
		moverSimple();
		if (x<=0 || x >= maxX - ancho - 1 )
			incX = -incX;
		if (y<=0 || y >= maxY - alto - 1)
			incY = -incY;		
	}
	
	public void moverContinuo (int maxX, int maxY ) {
		moverSimple();
		if (x<=0-ancho && incX <0)
			x = maxX-1;
		else
			if (x > maxX -1 && incX > 0)
				x = 0;
		if (y<=0-alto && incY < 0 )
			y = maxY-1;
		else 
			if (y > maxY -1 && incY > 0 )
			y = 0;		
	}
	
	public void moverContinuo2 (int maxX, int maxY ) {
		moverSimple();
		if (x<=-ancho && incX <0)
			x = maxX-ancho-1;
		else
			if (x > maxX - 1 && incX > 0)
				x = 0;
		if (y<=-alto && incY < 0 )
			y = maxY-alto-1;
		else 
			if (y > maxY -1 && incY > 0 )
			y = 0;		
	}
	public void moverContinuo3 (int maxX, int maxY ) {
		
		if (x<=0-ancho && incX <0)
			x = maxX-1;
		else
			if (x > maxX -1 && incX > 0)
				x = 0;
		if (y<=0-alto && incY < 0 )
			y = maxY-1;
		else 
			if (y > maxY -1 && incY > 0 )
			y = 0;		
	}
	
	public boolean colision (Figura f) {
		return interseccion ( this.getX(), this.getY(), this.getAncho(), this.getAlto(),   
				              f.getX(), f.getY(), f.getAncho(), f.getAlto()  );
	}
	
	private boolean interseccion ( int x1, int y1, int ancho1, int altura1, 
			int x2, int y2, int ancho2, int altura2 ) {
	
		// C�lcula las coordenadas faltantes de cada rect�ngulo
		int xp1 = x1 + ancho1;
		int yp1 = y1 + altura1;
		int xp2 = x2 + ancho2;
		int yp2 = y2 + altura2;
		
		// Verifica si hay intersecci�n calculando rect�ngulo (x,y) , (xp,yp)
		// El sistema de coordenadas es el de la Java API
		int x = Math.min(xp1, xp2);
		int xp = Math.max(x1, x2);
		if (x <= xp)
		    return false;
		else {
		    int y = Math.min(yp1, yp2);
		    int yp = Math.max(y1, y2);
		    if (y <= yp)
		        return false;
		    else
		        return true;
		}
	} // fin interseccion()


	

}