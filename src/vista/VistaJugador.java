package vista;

import java.util.ArrayList;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;

public class VistaJugador {

    Canvas canvas;
    int posicionActual;
    ArrayList<Integer> posicionesHorizontales;
    ArrayList<Integer> posicionesVerticales;

    public VistaJugador(Canvas canvas) {
        this.canvas = canvas;
        this.posicionActual = 0;
        
        //
        posicionesHorizontales = new ArrayList<Integer>();
        posicionesHorizontales.add(870);
        posicionesHorizontales.add(696);
        posicionesHorizontales.add(522);
        posicionesHorizontales.add(348);
        posicionesHorizontales.add(174);
        posicionesHorizontales.add(0); //5 carcel
        
        posicionesHorizontales.add(0); //6
        posicionesHorizontales.add(0);
        posicionesHorizontales.add(0);
        posicionesHorizontales.add(0);
        posicionesHorizontales.add(0); //10 impuesto de lujo
        
        posicionesHorizontales.add(174);
        posicionesHorizontales.add(348);
        posicionesHorizontales.add(522);
        posicionesHorizontales.add(696);
        posicionesHorizontales.add(870); //15 policia
   
        posicionesHorizontales.add(870);
        posicionesHorizontales.add(870);
        posicionesHorizontales.add(870);
        posicionesHorizontales.add(870);
        
        
        //
        posicionesVerticales = new ArrayList<Integer>();
        posicionesVerticales.add(450);
        posicionesVerticales.add(450);
        posicionesVerticales.add(450);
        posicionesVerticales.add(450);
        posicionesVerticales.add(450);
        posicionesVerticales.add(450); //5 carcel
        
        posicionesVerticales.add(360); //6
        posicionesVerticales.add(270);
        posicionesVerticales.add(180);
        posicionesVerticales.add(90);
        posicionesVerticales.add(0); //10 impuesto de lujo
        
        posicionesVerticales.add(0);
        posicionesVerticales.add(0);
        posicionesVerticales.add(0);
        posicionesVerticales.add(0);
        posicionesVerticales.add(0); //15 policia
        
        posicionesVerticales.add(90);
        posicionesVerticales.add(180);
        posicionesVerticales.add(270);
        posicionesVerticales.add(360); 
        
        
    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	
    	//clear
        canvas.getGraphicsContext2D().clearRect(0, 0, 930, 520);
        
        canvas.getGraphicsContext2D().setFill(Color.BLACK);
        canvas.getGraphicsContext2D().fillOval(posicionesHorizontales.get(posicionActual), posicionesVerticales.get(posicionActual), 50, 50);
    }

    public void update(int pasosTotal) {
    	for (int i = 0; i < pasosTotal; i++) {
    		posicionActual ++;
    		if (posicionActual == 20) {
    			posicionActual = 0;
    		}
    	}
        this.dibujar();
    }

}
