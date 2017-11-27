package vista;

import java.util.ArrayList;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;

public class VistaJugador {

	ArrayList<Jugador> jugadores;
	AlgoPoly algoPoly;
    Canvas canvas;

    public VistaJugador(Canvas canvas, AlgoPoly algoPoly) {

        this.jugadores = algoPoly.devolverJugadores();
        this.algoPoly = algoPoly;
        this.canvas = canvas;

    }

    public void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	
    	//clear
        canvas.getGraphicsContext2D().clearRect(0, 0, 930, 520);

        int contador = 0;
        int contadorHorizontal = 55;
        int contadorVertical = 65; //65 arriba de todo
        for (int i = 0; i < 3; i++){
        	Jugador jugador = jugadores.get(i);
        	if (i == 0)
        		canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        	if (i == 1)
        		canvas.getGraphicsContext2D().setFill(Color.RED);
        	if (i == 2)
        		canvas.getGraphicsContext2D().setFill(Color.BLACK);
        	
        	canvas.getGraphicsContext2D().fillOval(jugador.obtenerCoordenadaHorizontal() + contador, jugador.obtenerCoordenadaVertical() + contador, 45, 45);
        	contador += 7;
        	
        	String situacionJugador = algoPoly.pedirSituacion(jugador);
        	canvas.getGraphicsContext2D().fillText(situacionJugador, contadorHorizontal, contadorVertical);
        	canvas.getGraphicsContext2D().setFont(new Font("Verdana", 19));
        	
        	contadorHorizontal += 280;
        }
    }

    public void update() {
        this.dibujar();
    }

}
