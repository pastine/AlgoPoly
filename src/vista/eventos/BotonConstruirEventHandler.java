package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import modelo.AlgoPoly;
import modelo.propiedad.Propiedad;

public class BotonConstruirEventHandler implements EventHandler<ActionEvent> {
	private AlgoPoly algoPoly;
	private ListView<Propiedad> listaDePropiedades;
	
	public BotonConstruirEventHandler (AlgoPoly algoPoly, ListView<Propiedad> listaDePropiedades) {
		this.algoPoly = algoPoly;
		this.listaDePropiedades = listaDePropiedades;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	
 
    }
}