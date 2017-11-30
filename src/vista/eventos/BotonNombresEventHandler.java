package vista.eventos;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import modelo.AlgoPoly;
import vista.ContenedorBienvenidos;

public class BotonNombresEventHandler implements EventHandler<ActionEvent>{

	private final TextField nombre1Field;
	private final TextField nombre3Field;
	private final TextField nombre2Field;
	private final AlgoPoly algoPoly;
	private final ContenedorBienvenidos contenedor;
	
	
	public BotonNombresEventHandler(AlgoPoly algoPoly, ContenedorBienvenidos contenedor, TextField nombre1Field,  TextField nombre2Field, TextField nombre3Field) {
		this.algoPoly = algoPoly;
		this.contenedor = contenedor;
		this.nombre1Field = nombre1Field;
		this.nombre2Field = nombre2Field;
		this.nombre3Field = nombre3Field;
	}
	
	@Override
	public void handle(ActionEvent arg0) {
		this.algoPoly.cambiarNombres(this.nombre1Field.getText(), this.nombre2Field.getText(), this.nombre3Field.getText());
		contenedor.habilitarJugarTrasAceptar();
	}

}
