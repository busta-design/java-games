 package highway;

import java.awt.Color;
import java.util.concurrent.ThreadLocalRandom;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


 public class JuegoCarretera {
	private final JFrame ventana;
    private final Nave jug;
  
    private final Obstaculo[] obst;  //arreglo
    private final Vidas[] vid;  //arreglo 
    private final PanelJuego panel;
    private final Obstaculo[] obst2;
    private int contador;
    private final String nick;
    private int puntaje;
    private Score score;
    
    public JuegoCarretera(String nick){ //constructor
        ventana = new JFrame ("Raquet Pro");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(250, 350);
        ventana.setLocationRelativeTo(null);
        
        puntaje =0;
        score = new Score(10, 290, puntaje, nick);
        jug = new Nave (50, 250); 
  
        obst = new Obstaculo[10];
        for (int i=0; i< obst.length ; i++)
        	obst[i] = new Obstaculo ( ThreadLocalRandom.current().nextInt(50-20+1)+20, 
        			-ThreadLocalRandom.current().nextInt(250));
        
        obst2 = new Obstaculo[10];
        for (int i=0; i< obst2.length ; i++)
        	obst2[i] = new Obstaculo ( ThreadLocalRandom.current().nextInt(180-150+1)+150, 
        			-ThreadLocalRandom.current().nextInt(250));
        
        vid = new Vidas[3];
        vid[0] = new Vidas (190, 300);
        vid[1] = new Vidas (160, 300);
        vid[2] = new Vidas (130, 300);
        
        panel = new PanelJuego ( jug,obst, obst2, vid, score);
       
        ventana.add (panel);
        
        ventana.setVisible(true);
        
        contador = 0;
        this.nick = nick;
        
        
	}
    
 public void jugar () {
	 
			for ( Obstaculo o: obst) {
		    		
		    		o.moverSimple();
		    		ventana.repaint();
			}
			for ( Obstaculo o: obst2) {
	    		
	    		o.moverSimple();
	    		ventana.repaint();
		}
    		
    	for ( Obstaculo o1: obst) {
    		if(o1.getY()>250) {
    		o1.setX(	ThreadLocalRandom.current().nextInt(50-20+1)+20); 
    		o1.setY(	-ThreadLocalRandom.current().nextInt(250));
    		}
    		puntaje++;
    		score.setScore(puntaje);
    		
    	}
    	for ( Obstaculo o2: obst2) {
    		if(o2.getY()>250) {
    		o2.setX(	ThreadLocalRandom.current().nextInt(180-150+1)+150); 
    		o2.setY(	-ThreadLocalRandom.current().nextInt(250));
    		}
    		puntaje++;
    		score.setScore(puntaje);
    	}
    	
    	for(Obstaculo o: obst) {
    	if ( jug.colision(o) ) {
    		contador++;
    		// seteamos para que rebote y no se cierre
    		//p.setIncY( -p.getIncY() );
    		switch(contador) {
    		case 1: 
    			//p.setIncY( -p.getIncY() );
    			vid[2].setColor(Color.GRAY);
    			JOptionPane.showMessageDialog (null, "Te quedan 2 vidas");
    			jug.setX(100);
    			jug.setY(250);
    			
    			break;
    		case 2: 
    			//p.setIncY( -p.getIncY() );
    			vid[1].setColor(Color.GRAY);
    			JOptionPane.showMessageDialog (null, "Te queda 1 vida");
    			jug.setX(100);
    			jug.setY(250);
    			
    			break;
    		case 3: 
    			vid[0].setColor(Color.GRAY);
    			
    			break;
    			default: 
    				
    				
            			try {
        					Thread.sleep(100);
        				} catch(InterruptedException ex) {
        					Thread.currentThread().interrupt();
        				} // fin del retardo
            		JOptionPane.showMessageDialog (null, "Perdiste el juego " + nick + ".\nTu score es " +puntaje);
        			System.exit(0);
            		
    				
    		}	
    		
    	}
    	
    		
    	}
    	
    	for(Obstaculo o: obst2) {
        	if ( jug.colision(o) ) {
        		contador++;
        		// seteamos para que rebote y no se cierre
        		//p.setIncY( -p.getIncY() );
        		switch(contador) {
        		case 1: 
        			//p.setIncY( -p.getIncY() );
        			vid[2].setColor(Color.GRAY);
        			JOptionPane.showMessageDialog (null, "Te quedan 2 vidas");
        			jug.setX(100);
        			jug.setY(250);
        			
        			break;
        		case 2: 
        			//p.setIncY( -p.getIncY() );
        			vid[1].setColor(Color.GRAY);
        			JOptionPane.showMessageDialog (null, "Te queda 1 vida");
        			jug.setX(100);
        			jug.setY(250);
        			
        			break;
        		case 3: 
        			vid[0].setColor(Color.GRAY);
        			
        			break;
        			default: 
        				
        				
                			try {
            					Thread.sleep(100);
            				} catch(InterruptedException ex) {
            					Thread.currentThread().interrupt();
            				} // fin del retardo
                		JOptionPane.showMessageDialog (null, "Perdiste el juego " + nick + ".\nTu score es " +puntaje);
            			System.exit(0);
                		
        				
        		}	
        		
        	}
        	
        		
        	}
   	 	
    	
    	//System.out.println (jug);
    }
}







