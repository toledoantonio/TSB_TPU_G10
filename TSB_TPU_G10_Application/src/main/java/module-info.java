module g10.pruebainterfaz {
    requires javafx.controls;
    requires javafx.fxml;


    opens g10.Interfaz to javafx.fxml;
    exports g10.Interfaz;
}