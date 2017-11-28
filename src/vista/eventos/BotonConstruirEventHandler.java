package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.propiedad.Propiedad;

public class BotonConstruirEventHandler implements EventHandler<ActionEvent> {
	private AlgoPoly algoPoly;
	private ListView<Propiedad> listaDePropiedades;
	private Stage ventana;
	
	public BotonConstruirEventHandler (Stage ventana, AlgoPoly algoPoly, ListView<Propiedad> listaDePropiedades) {
		this.algoPoly = algoPoly;
		this.listaDePropiedades = listaDePropiedades;
		this.ventana = ventana;
	}
	
    @Override
    public void handle(ActionEvent actionEvent) {
    	Propiedad propiedadSeleccionada = listaDePropiedades.getSelectionModel().getSelectedItem();
    	if (propiedadSeleccionada==null) return;
    	algoPoly.construir(propiedadSeleccionada);
    	ventana.close();
    }
}