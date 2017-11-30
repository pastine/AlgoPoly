package vista;

import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import modelo.AlgoPoly;

class VistaDados {
    private final AlgoPoly algoPoly;
    private final Canvas canvas;
    private final Stage stage;

    public VistaDados(Stage stage, Canvas canvas, AlgoPoly algoPoly) {
        this.algoPoly = algoPoly;
        this.canvas = canvas;
        this.stage = stage;
    }

    private void recargarImagenes(){
        canvas.getGraphicsContext2D().clearRect(0, 0, 220, 220);
        canvas.getGraphicsContext2D().setFill(Color.WHITE);
        String urlPrimerDado = "";
        String urlSegundoDado = "";

        for (int i = 1; i < 7; i++) {
            if (algoPoly.obtenerPrimerDadoActual() == i)
                urlPrimerDado = "vista/imagenes/dado" + i + ".jpg";
            if (algoPoly.obtenerSegundoDadoActual() == i)
                urlSegundoDado = "vista/imagenes/dado" + i + ".jpg";
        }
        Image imagenDado1 = new Image(urlPrimerDado, 100, 100, false, false);
        Image imagenDado2 = new Image(urlSegundoDado, 100, 100, false, false);

        canvas.getGraphicsContext2D().drawImage(imagenDado1,0,0);
        canvas.getGraphicsContext2D().drawImage(imagenDado2,0,100);

        if (algoPoly.obtenerPrimerDadoActual() == algoPoly.obtenerSegundoDadoActual()){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.initOwner(stage);
            alert.setTitle("Turno perdido");
            alert.setHeaderText(null);
            alert.setContentText("Por haber sacado dos veces dados iguales perdes el turno!");

            alert.showAndWait();
        }
    }


    public void update() {
        this.recargarImagenes();
    }
}
