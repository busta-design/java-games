package infection;

import java.awt.Graphics;

import javax.swing.JPanel;

public class FiguraPanel2 extends JPanel{
	
	Figura[] figura;


	public FiguraPanel2(Figura[] figura) {
		this.figura = figura;
	}


	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		for (Figura f: figura )
			f.dibujar( g );
	}


}
