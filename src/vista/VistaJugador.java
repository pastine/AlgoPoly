package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;

import java.util.ArrayList;

public class VistaJugador {
	private final AlgoPoly algoPoly;
	private final Stage stage;
    private final Canvas canvas;

    public VistaJugador(Stage stage,Canvas canvas, AlgoPoly algoPoly) {
        this.algoPoly = algoPoly;
        this.canvas = canvas;
        this.stage = stage;

    }

    private void dibujar() {
        this.dibujarFormas();
    }

    private void dibujarFormas() {
    	
    	//clear
        canvas.getGraphicsContext2D().clearRect(0, 0, 930, 520);
        
        ArrayList<Jugador> jugadores = algoPoly.devolverJugadores();
        
        int contador = 0;
        int contadorHorizontal = 55;
        int contadorVertical = 65; //65 arriba de todo
        for (int i = 0; i < jugadores.size(); i++){
        	Jugador jugador = jugadores.get(i);
        	if (i == 0)
        		canvas.getGraphicsContext2D().setFill(Color.DARKBLUE);
        	if (i == 1)
        		canvas.getGraphicsContext2D().setFill(Color.RED);
        	if (i == 2)
        		canvas.getGraphicsContext2D().setFill(Color.GREEN);
        	
        	canvas.getGraphicsContext2D().fillOval(jugador.obtenerCoordenadaHorizontal() + contador, jugador.obtenerCoordenadaVertical() + contador, 45, 45);
        	contador += 7;
        	
        	String situacionJugador = algoPoly.pedirSituacionJugador(jugador);
        	canvas.getGraphicsContext2D().setFont(new Font("Verdana", 15));
        	canvas.getGraphicsContext2D().fillText(situacionJugador, contadorHorizontal, contadorVertical);
        	canvas.getGraphicsContext2D().setFill(Color.BLACK);
        	contadorHorizontal += 280;
        }
        
        
        String situacionCasillero = algoPoly.pedirSituacionCasillero(algoPoly.devolverJugadorActual());
        canvas.getGraphicsContext2D().fillText(situacionCasillero, 345, 355);

        if (jugadores.size() == 1){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(stage);
            alert.setTitle("Felicitaciones");
            alert.setHeaderText(null);
            alert.setContentText("El jugador " + jugadores.get(0).pedirNombre() + " es el ganador!");

            alert.showAndWait();
        }
    }

    public void update() {
        this.dibujar();
    }

}
