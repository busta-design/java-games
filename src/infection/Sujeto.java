package infection;

import java.awt.Color;
import java.security.SecureRandom;

public class Sujeto extends Cuadrado{
	
	private static int tam;
	private boolean contagiado;
	private boolean recuperado;
	private int x0, y0, x1, y1; //limites area en movimiento 
	private final static SecureRandom nAl = new SecureRandom();
	
	private int contador;
	
	public Sujeto(int tam, int ancho, int alto) {
		super(0, 0, tam, Color.BLUE, 0, 0);
		contagiado = false; 
		calcularPosicion(ancho, alto); 
		setIncX(nAl.nextInt(2)*2-1);
		setIncY(nAl.nextInt(2)*2-1);
		contador = 0;
	}
	public Sujeto(int tam, int ancho, int alto, int anchoMov, int altoMov) {
		super(0, 0, tam, Color.BLUE, 0, 0);
		contagiado = false; 
		calcularPosicion (ancho, alto, anchoMov, altoMov);
		setIncX(nAl.nextInt(2)*2-1);
		setIncY(nAl.nextInt(2)*2-1);
		contador = 0;
	}
	
	
	public void calcularPosicion(int ancho, int alto) {
		setX(nAl.nextInt(ancho - getAncho()-1)+1); 
		setY(nAl.nextInt(alto - getAlto()-1)+1);
		x0= y0 = x1 = y1 = 0;
	}
	
	
	public void calcularPosicion(int ancho, int alto, int anchoMov, int altoMov) {
		setX(nAl.nextInt(ancho - getAncho()-1)+1);
		setY(nAl.nextInt(alto - getAlto()-1)+1);
		x0 = getX() - anchoMov;
		y0 = getY() - altoMov;
		x1 = getX() + anchoMov;
		y1 = getY() + altoMov;
		
	}
	
	public boolean isContagiado() {
		return contagiado;
	}
	
	public void setContagiado(boolean contagio) {
		this.contagiado=contagio;
		if (contagiado)
			setColor(Color.RED);
		else 
			setColor(Color.BLUE);
	}
	public boolean isRecuperado() {
		return recuperado;
	}
	public void setRecuperado(boolean recuperado) {
		this.recuperado = recuperado; 
		if(recuperado)
			setColor(Color.YELLOW);
		
	}
	public void moverAcotado2() {
		moverSimple();
		if (getX()<=x0 || getX() >= x1 - getAncho() - 1 )
			setIncX (-getIncX());
		if (getY()<=y0 || getY() >= y1 - getAlto() - 1 )
			setIncY (-getIncY());
	

	

}
	public int getContador() {
	
		return contador;
	}
	public void setContador(int contador) {
		this.contador =+ contador;
		if(this.contador >= 50) {
			this.contador = 0;
		}
	}
	public void recuperacion() {
		if (isContagiado()== true) {
			contador = contador + 1; 
		}
		if(this.contador>=100) {
			contador = 0;
			setContagiado(false);
		}
	}
	
	
	
	
	
	
}
