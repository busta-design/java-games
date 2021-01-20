package highway;

import javax.swing.JOptionPane;

public class HighwayMainTest {
	
	 public static void main(String[] args) {
		 
		 	String nick = JOptionPane.showInputDialog(null, "nombre");
	    	JuegoCarretera juego = new JuegoCarretera(nick);
	    	JOptionPane.showMessageDialog(null, "Bienvenido "+ nick);
	    	
	    	
	        while (true) {
	        
	           	juego.jugar();
	        	
	        	try {
					Thread.sleep(30);
				} catch(InterruptedException ex) {
					Thread.currentThread().interrupt();
				} // fin del retardo

	        } // while
	        
	        
	    } //main()

}
