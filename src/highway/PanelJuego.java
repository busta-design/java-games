package highway;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

public class PanelJuego extends JPanel implements KeyListener {
	
	/**
	 * 
	 */
	
	Nave jug;
	Obstaculo[] obst;
	Obstaculo[] obst2;
	
	Vidas vid[];
	Score score;
	
	
	public PanelJuego(Nave j,  Obstaculo[] obst, Obstaculo[] obst2, Vidas[] vid, Score score) {
		this.jug = j;
		this.obst = obst;
	
		this.vid= vid;
		this.score=score;
		this.obst2=obst2;
		setFocusable (true);
		addKeyListener(this);
	}
	
	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		setBackground(Color.BLACK);
		jug.dibujar(g);
		
		score.dibujar(g);
		
		for (Obstaculo o: obst)
			o.dibujar(g);
		for (Vidas v: vid)
			v.dibujar(g);
		for (Obstaculo ob: obst2)
			ob.dibujar(g);
		
	}
	 
	
	@Override
	public void keyTyped(KeyEvent e) {
	}
	
	@Override
	public void keyPressed( KeyEvent event ) {
		
		System.out.println(event.getKeyCode());
		
		switch ( event.getKeyCode() ) {
		case 32: // barra de espacio
			
			break;
		case 37: // izquierda
			jug.setX(jug.getX() -10);
			break;
		case 38: // arriba
			//jug.setY(jug.getY() -10 );
			break;
		case 39: // derecha
			jug.setX(jug.getX() +10);
			break;
		case 40: // abajo
			//jug.setY(jug.getY() +10  );
		} // switch
	} // keyPressed()
	
	
	@Override
	public void keyReleased(KeyEvent e) {
	}



}
