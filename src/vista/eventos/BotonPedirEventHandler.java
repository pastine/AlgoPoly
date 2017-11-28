package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;
import modelo.AlgoPoly;


public class BotonPedirEventHandler implements EventHandler<ActionEvent> {
	AlgoPoly algoPoly;
    public BotonPedirEventHandler(AlgoPoly algoPoly) {
		this.algoPoly = algoPoly;
	}



	@Override
    public void handle(ActionEvent actionEvent) {
    	Dialog<Pair<String, String>> dialogo = new Dialog<>();
    	dialogo.setTitle("Nombre de jugadores");
    	dialogo.setHeaderText("Ingrese nombre de jugadores");

    	ButtonType aceptarButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
    	dialogo.getDialogPane().getButtonTypes().addAll(aceptarButtonType, ButtonType.CANCEL);

    	GridPane grid = new GridPane();
    	grid.setHgap(10);
    	grid.setVgap(10);
    	grid.setPadding(new Insets(20, 150, 10, 10));

    	TextField jugador1 = new TextField();
    	jugador1.setPromptText("nombre jugador 1");
    	
    	TextField jugador2 = new TextField();
    	jugador2.setPromptText("nombre jugador 2");
    	
    	TextField jugador3 = new TextField();
    	jugador3.setPromptText("nombre jugador 3");
    	
    	grid.add(new Label("Jugador 1:"), 0, 0);
    	grid.add(jugador1, 1, 0);
    	
    	grid.add(new Label("Jugador 2:"), 0, 1);
    	grid.add(jugador2, 1, 1);

    	grid.add(new Label("Jugador 3:"), 0, 2);
    	grid.add(jugador3, 1, 2);

    	dialogo.getDialogPane().setContent(grid);

    	dialogo.setResultConverter(dialogButton -> {
    	    if (dialogButton == aceptarButtonType) {
    	    	algoPoly.cambiarNombres(jugador1.getText(), jugador2.getText(), jugador3.getText()); // cambia nombre de jugadores
    	    	
    	    }
    	    return null;
    	});

    	dialogo.showAndWait();

    }

}
