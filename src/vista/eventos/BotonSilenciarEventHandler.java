package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.MediaPlayer;




public class BotonSilenciarEventHandler  implements EventHandler<ActionEvent> {
	private MediaPlayer mediaplayer;
	public BotonSilenciarEventHandler (MediaPlayer mediaplayer) {
		this.mediaplayer = mediaplayer;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	mediaplayer.stop();
 
    }
}
