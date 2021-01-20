package highway;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import infection.Figura;


public class Score extends Figura {
	
	private int score;
	private int x;
	private int y;
	private String nick;
	private Font font;
	public Score(int x, int y, int score, String nick) {
		super(x, y, score, Color.WHITE );
		this.score=score;
		this.x=x;
		this.y=y;
		this.nick=nick;
		this.font= new Font ("ROMAN_BASELINE", Font.BOLD, 12);
		
		
	}
	
	
	@Override
	public void trazar(Graphics g) {
		g.setFont(font);
		g.drawString (nick +"   Tu puntaje es: "+score, x, y );
		
		
	}


	@Override
	public void trazar(Graphics g, int maxX, int maxY) {
		// TODO Auto-generated method stub
		
	}


	public void setScore(int score) {
		this.score = score;
	}
	

			
	

}
