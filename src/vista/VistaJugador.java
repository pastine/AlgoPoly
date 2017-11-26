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

    public VistaJugador(Canvas canvas, AlgoPoly algoPoly) {

        this.jugadores = algoPoly.devolverJugadores();

        this.canvas = canvas;

    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	
    	//clear
        canvas.getGraphicsContext2D().clearRect(0, 0, 930, 520);

        for (int i = 0; i < 3; i++){
        	Jugador jugador = jugadores.get(i);
        	if (i == 0)
        		canvas.getGraphicsContext2D().setFill(Color.GREEN);
        	if (i == 1)
        		canvas.getGraphicsContext2D().setFill(Color.RED);
        	if (i == 2)
        		canvas.getGraphicsContext2D().setFill(Color.BLACK);
        	canvas.getGraphicsContext2D().fillOval(jugador.obtenerCoordenadaHorizontal(), jugador.obtenerCoordenadaVertical(), 50, 50);
        
        }
    }

    public void update(int pasosTotal, Jugador jugadorActual) {
        this.dibujar();
    }

}
