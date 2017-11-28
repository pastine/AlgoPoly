package vista;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelo.AlgoPoly;
import modelo.jugador.Jugador;
import modelo.propiedad.Propiedad;
import vista.eventos.BotonVenderEventHandler;

import java.util.ArrayList;

public class VenderVentana {
    public static void MostrarVentana(Stage stage,AlgoPoly algoPoly) {
        Stage ventana = new Stage();
        ventana.initOwner(stage);
        ventana.initModality(Modality.APPLICATION_MODAL);
        ventana.setTitle("Vender");
        VBox layout = new VBox(5);
        Scene escena = new Scene(layout);
        setEscena(ventana,layout,algoPoly);
        ventana.setScene(escena);
        ventana.showAndWait();
    }

    private static void setEscena(Stage ventana,VBox layout,AlgoPoly algoPoly) {
        layout.setAlignment(Pos.CENTER);
        Jugador jugadorActual = algoPoly.devolverJugadorActual();
        ArrayList<Propiedad> propiedades = algoPoly.obtenerPropiedades(jugadorActual);
        ListView<Propiedad> listaDePropiedades = new ListView<>();
        for (int i=0; i<propiedades.size();i++) {
            listaDePropiedades.getItems().add(propiedades.get(i));
        }
        Button botonVender = new Button();
        botonVender.setText("Vender");
        BotonVenderEventHandler botonVenderHandler = new BotonVenderEventHandler(ventana,algoPoly,listaDePropiedades);
        botonVender.setOnAction(botonVenderHandler);


        layout.getChildren().addAll(listaDePropiedades,botonVender);
    }
}
