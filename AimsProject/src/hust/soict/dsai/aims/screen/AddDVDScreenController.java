package hust.soict.dsai.aims.screen;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddDVDScreenController {

    private Store store;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSave;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfDirector;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddDVDScreenController(Store store) {
        this.store = store;
    }

    @FXML
    void btnSavePressed(ActionEvent event) {
        DigitalVideoDisc dvd = createDVD();
        if (dvd != null) {
            store.addMedia(dvd);
            clearFields();
            showAlert("DVD has been added to the store!", "Success", Alert.AlertType.INFORMATION);
        }
    }

    @FXML
    void initialize() {
        btnSave.setDisable(true);
        addTextListeners();
    }

    private void addTextListeners() {
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfDirector.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private DigitalVideoDisc createDVD() {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String director = tfDirector.getText();
        int length = parseLength();
        if (length == -1) return null;

        float cost = parseCost();
        if (cost == -1) return null;

        return new DigitalVideoDisc(title, category, director, length, cost);
    }

    private int parseLength() {
        try {
            return Integer.parseInt(tfLength.getText());
        } catch (NumberFormatException e) {
            showAlert("Failed to parse length!", "Wrong type", Alert.AlertType.ERROR);
            return -1;
        }
    }

    private float parseCost() {
        try {
            return Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            showAlert("Failed to parse cost!", "Wrong type", Alert.AlertType.ERROR);
            return -1;
        }
    }

    private void showAlert(String content, String title, Alert.AlertType alertType) {
        Alert alert = new Alert(alertType, content);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    private void clearFields() {
        tfTitle.clear();
        tfCategory.clear();
        tfDirector.clear();
        tfLength.clear();
        tfCost.clear();
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && 
                           !tfCategory.getText().isEmpty() && 
                           !tfDirector.getText().isEmpty() && 
                           !tfLength.getText().isEmpty() && 
                           !tfCost.getText().isEmpty();
        btnSave.setDisable(!allFieldsFilled);
    }
}
