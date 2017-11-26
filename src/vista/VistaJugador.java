package vista;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;

public class VistaJugador {

	ArrayList<Jugador> jugadores;
    Canvas canvas;
    HashMap<Jugador, Integer> posicionesActuales;
    ArrayList<Integer> posicionesHorizontales;
    ArrayList<Integer> posicionesVerticales;

    public VistaJugador(Canvas canvas, AlgoPoly algoPoly) {
    	
        this.jugadores = algoPoly.devolverJugadores();
        
        this.canvas = canvas;
        this.posicionesActuales = new HashMap<Jugador, Integer>();
        for(Jugador jugador : jugadores) {
        	 this.posicionesActuales.put(jugador, 0);
        }
        
        //
        posicionesHorizontales = new ArrayList<Integer>();
        posicionesHorizontales.add(870);
        posicionesHorizontales.add(696);
        posicionesHorizontales.add(522);
        posicionesHorizontales.add(348);
        posicionesHorizontales.add(174);
        posicionesHorizontales.add(0); //5 carcel
        
        posicionesHorizontales.add(0);
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
        
        posicionesVerticales.add(360);
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
        
        int contador = 0;
        for (Map.Entry<Jugador, Integer> tupla : posicionesActuales.entrySet()) {
        	Jugador jugador = tupla.getKey();
        	int posicionActual = tupla.getValue();
        	if (contador == 0)
        		canvas.getGraphicsContext2D().setFill(Color.GREEN);
        	if (contador == 1)
        		canvas.getGraphicsContext2D().setFill(Color.RED);
        	if (contador == 2)
        		canvas.getGraphicsContext2D().setFill(Color.BLACK);
        	contador ++;
        	canvas.getGraphicsContext2D().fillOval(posicionesHorizontales.get(posicionesActuales.get(jugador)), posicionesVerticales.get(posicionesActuales.get(jugador)), 50, 50);
        
        }
    }

    public void update(int pasosTotal, Jugador jugadorActual) {
    	for (int i = 0; i < pasosTotal; i++) {
    		int posicionActual = posicionesActuales.get(jugadorActual);
    		
    		posicionActual ++;
    		if (posicionActual == 20) {
    			posicionActual = 0;
    		}
    		posicionesActuales.put(jugadorActual, posicionActual);
    	}
        this.dibujar();
    }

}
