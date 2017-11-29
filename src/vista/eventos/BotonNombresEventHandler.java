package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.AlgoPoly;

public class BotonNombresEventHandler implements EventHandler<ActionEvent>{

	private TextField nombre1Field;
	private TextField nombre3Field;
	private TextField nombre2Field;
	private AlgoPoly algoPoly;
	
	
	public BotonNombresEventHandler(AlgoPoly algoPoly, TextField nombre1Field,  TextField nombre2Field, TextField nombre3Field) {
		this.algoPoly = algoPoly;
		this.nombre1Field = nombre1Field;
		this.nombre2Field = nombre2Field;
		this.nombre3Field = nombre3Field;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.algoPoly.cambiarNombres(this.nombre1Field.getText(), this.nombre2Field.getText(), this.nombre3Field.getText());
		
	}

}
