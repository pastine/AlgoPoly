package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;
import vista.ContenedorPrincipal;

public class BotonReproducirMusicaEventHandler implements EventHandler<ActionEvent>{
	
	private final MediaPlayer mediaplayer;
	private final ContenedorPrincipal contenedor;
	
	public BotonReproducirMusicaEventHandler (ContenedorPrincipal contenedor, MediaPlayer mediaplayer) {
		this.mediaplayer = mediaplayer;
		this.contenedor = contenedor;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	mediaplayer.play();
    	contenedor.deshabilitarTrasReproducir();
    }
}
