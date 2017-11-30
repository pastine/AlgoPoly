package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;
import vista.ContenedorPrincipal;

public class BotonSilenciarEventHandler  implements EventHandler<ActionEvent> {
	
	private final MediaPlayer mediaplayer;
	private final ContenedorPrincipal contenedor;
	
	public BotonSilenciarEventHandler (ContenedorPrincipal contenedor, MediaPlayer mediaplayer) {
		this.mediaplayer = mediaplayer;
		this.contenedor = contenedor;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	mediaplayer.stop();
    	contenedor.deshabilitarTrasSilenciar();
    }
}
