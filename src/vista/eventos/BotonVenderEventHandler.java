package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.propiedad.Propiedad;

public class BotonVenderEventHandler implements EventHandler<ActionEvent> {
    private final AlgoPoly algoPoly;
    private final ListView<Propiedad> listaDePropiedades;
    private final Stage ventana;

    public BotonVenderEventHandler (Stage ventana, AlgoPoly algoPoly, ListView<Propiedad> listaDePropiedades) {
        this.algoPoly = algoPoly;
        this.listaDePropiedades = listaDePropiedades;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Propiedad propiedadSeleccionada = listaDePropiedades.getSelectionModel().getSelectedItem();
        if (propiedadSeleccionada==null) return;
        algoPoly.devolverJugadorActual().venderPropiedad(propiedadSeleccionada);
        ventana.close();
    }
}