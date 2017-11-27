package vista.eventos;

import java.util.Optional;

import javafx.application.*;
import javafx.geometry.*;
import javafx.event.*;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.*;
import javafx.util.Pair;


public class BotonPedirEventHandler implements EventHandler<ActionEvent> {

    @Override
    public void handle(ActionEvent actionEvent) {
    	// Create the custom dialog.
    	Dialog<Pair<String, String>> dialog = new Dialog<>();
    	dialog.setTitle("Nombre de jugadores");
    	dialog.setHeaderText("Ingrese nombre de jugadores");

    	// Set the icon (must be included in the project).
    	//dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

    	// Set the button types.
    	ButtonType aceptarButtonType = new ButtonType("Aceptar", ButtonData.OK_DONE);
    	dialog.getDialogPane().getButtonTypes().addAll(aceptarButtonType, ButtonType.CANCEL);

    	// Create the username and password labels and fields.
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

    	

    	dialog.getDialogPane().setContent(grid);

    	

    	// Convierte el resultado de cuando tocan aceptar
    	dialog.setResultConverter(dialogButton -> {
    	    if (dialogButton == aceptarButtonType) {
    	    	System.out.println(jugador1.getText());
        		System.out.println(jugador2.getText());
        		System.out.println(jugador3.getText());
    	    }
    	    return null;
    	});

    	dialog.showAndWait();

    }

}
