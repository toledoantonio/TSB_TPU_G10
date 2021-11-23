package g10.Interfaz;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.stage.FileChooser;
import Negocio.Departamento;
import Negocio.Departamentos;
import java.io.File;
import java.util.Collection;

public class SelectorVacunasController {
    public Button browseButton;
    public Button loadButton;
    public ComboBox selectCMB;
    public ComboBox taskCMB;
    public ListView displayLV;
    public Label pathLBL;

    public void browseButtonAction(ActionEvent actionEvent) {
        FileChooser archChooser = new FileChooser();
        File file = archChooser.showOpenDialog(null);
        if (file != null){
            pathLBL.setText(file.getAbsolutePath());}
        loadButton.setDisable(false);
    }

    public void loadButtonAction(ActionEvent actionEvent) {
        Departamentos departamentos = new Departamentos();
        departamentos.contarVacunaciones(pathLBL.getText());

        selectCMB.setDisable(false);

        ObservableList ol;
        Collection deptos = departamentos.getDeptos();
        ol = FXCollections.observableArrayList(deptos);
        selectCMB.setItems(ol);

        ol = FXCollections.observableArrayList("Por_dosis","Por_sexo","Por_vacuna");
        taskCMB.setItems(ol);
    }

    public void taskCMBAction(ActionEvent actionEvent) {

        ObservableList ol;

        Departamento depto = (Departamento) selectCMB.getValue();

        if (taskCMB.getValue() == "Por_dosis") {
            ol = FXCollections.observableArrayList(depto.getPrimerDosis(),depto.getSegundaDosis());
            displayLV.setItems(ol);
        }
        else if (taskCMB.getValue() == "Por_sexo") {
            ol = FXCollections.observableArrayList(depto.getContMasculino(),depto.getContFemenino());
            displayLV.setItems(ol);
        }
        else {
            ol = FXCollections.observableArrayList(depto.getVacunas());
            displayLV.setItems(ol);
        }
    }
}