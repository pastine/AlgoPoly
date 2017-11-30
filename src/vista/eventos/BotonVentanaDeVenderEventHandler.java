package vista.eventos;

        import javafx.event.ActionEvent;
        import javafx.event.EventHandler;
        import javafx.stage.Stage;
        import modelo.AlgoPoly;
        import vista.VenderVentana;
        import vista.VistaJugador;


public class BotonVentanaDeVenderEventHandler implements EventHandler<ActionEvent> {
    private final Stage stage;
    private final AlgoPoly algoPoly;
    private final VistaJugador vistaJugador;

    public BotonVentanaDeVenderEventHandler (Stage stage, AlgoPoly algoPoly, VistaJugador vistaJugador) {
        this.stage = stage;
        this.algoPoly = algoPoly;
        this.vistaJugador = vistaJugador;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        VenderVentana.MostrarVentana(stage,algoPoly);
        vistaJugador.update();
    }
}