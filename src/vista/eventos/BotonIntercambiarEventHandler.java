package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;

public class BotonIntercambiarEventHandler implements EventHandler<ActionEvent> {
    private AlgoPoly algoPoly;
    private ListView<Propiedad> listaDePropiedadesJugadorActual;
    private ListView<Jugador> listaDeJugadores;
    private ListView<Propiedad> listaDePropiedadesOtroJugador;
    private Stage ventana;

    public BotonIntercambiarEventHandler (Stage ventana, AlgoPoly algoPoly, ListView<Jugador> listaDeJugadores, ListView<Propiedad> listaDePropiedadesJugadorActual, ListView<Propiedad> listaDePropiedadesOtroJugador) {
        this.algoPoly = algoPoly;
        this.listaDePropiedadesJugadorActual = listaDePropiedadesJugadorActual;
        this.listaDeJugadores = listaDeJugadores;
        this.listaDePropiedadesOtroJugador = listaDePropiedadesOtroJugador;
        this.ventana = ventana;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Propiedad propiedadJugadorActual = listaDePropiedadesJugadorActual.getSelectionModel().getSelectedItem();
        Jugador jugadorSeleccionado = listaDeJugadores.getSelectionModel().getSelectedItem();
        Propiedad propiedadJugadorSeleccionado = listaDePropiedadesOtroJugador.getSelectionModel().getSelectedItem();
        if (propiedadJugadorActual==null || propiedadJugadorSeleccionado == null) return;
        
        algoPoly.devolverJugadorActual().intercambiarPropiedad(jugadorSeleccionado, propiedadJugadorActual, propiedadJugadorSeleccionado);
        ventana.close();
    }
}