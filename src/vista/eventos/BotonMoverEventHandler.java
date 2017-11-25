package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import modelo.jugador.Jugador;
import vista.VistaJugador;

public class BotonMoverEventHandler implements EventHandler<ActionEvent> {
	
	Jugador jugador;
	VistaJugador vistaJugador;

	public BotonMoverEventHandler (Jugador jugador, VistaJugador vistaJugador) {
		this.jugador = jugador;
		this.vistaJugador = vistaJugador;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	int pasosTotal = jugador.lanzarDados();
        //jugador.mover(pasosTotal);
        vistaJugador.update(pasosTotal);
        System.out.println(pasosTotal);
    }
    
}
