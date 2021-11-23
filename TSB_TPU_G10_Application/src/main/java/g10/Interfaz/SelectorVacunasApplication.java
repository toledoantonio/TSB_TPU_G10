package g10.Interfaz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class SelectorVacunasApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SelectorVacunasApplication.class.getResource("ContadorVacunasVentana.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 580, 550);
        stage.setTitle("Trabajo Practico Unico - TSB");
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}