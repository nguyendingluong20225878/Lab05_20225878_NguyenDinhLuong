package hust.soict.dsai.aims.screen;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.screen.AddTrack;
import hust.soict.dsai.aims.store.store.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddCDScreenController {

    private Store store;
    
    private CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnAddTrack;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnAddCD;

    @FXML
    private TextField tfCategory;

    @FXML
    private TextField tfCost;

    @FXML
    private TextField tfArtist;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    public AddCDScreenController(Store store) {
        super();
        this.store = store;
    }

    @FXML
    void handleAddCDButton(ActionEvent event) {
        store.addMedia(CD);
        resetFields();
        showAlert(Alert.AlertType.INFORMATION, "CD has been added to the store!", "Success");
        disableButtons();
    }

    @FXML
    void handleAddTrackButton(ActionEvent event) {
        new AddTrack(CD);
    }

    @FXML
    void handleSaveButton(ActionEvent event) {
        String title = tfTitle.getText();
        String category = tfCategory.getText();
        String artist = tfArtist.getText();
        float cost = 0.0f;
        try {
            cost = Float.parseFloat(tfCost.getText());
        } catch (NumberFormatException e) {
            showAlert(Alert.AlertType.ERROR, "Failed to parse cost!", "Wrong type");
            return;
        }
        CD = new CompactDisc(title, category, artist, cost);
        enableButtons();
    }

    @FXML
    void initialize() {
        disableButtons();
        addTextFieldListeners();
    }

    private void addTextFieldListeners() {
        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCategory.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfArtist.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfCost.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    private void checkFieldsFilled() {
        allFieldsFilled = !tfTitle.getText().isEmpty() && !tfCategory.getText().isEmpty() && !tfArtist.getText().isEmpty() && !tfCost.getText().isEmpty();
        btnSave.setDisable(!allFieldsFilled);
    }

    private void resetFields() {
        tfTitle.clear();
        tfCategory.clear();
        tfArtist.clear();
        tfCost.clear();
    }

    private void disableButtons() {
        btnSave.setDisable(true);
        btnAddCD.setDisable(true);
        btnAddTrack.setDisable(true);
    }

    private void enableButtons() {
        btnSave.setDisable(true);
        btnAddCD.setDisable(false);
        btnAddTrack.setDisable(false);
    }

    private void showAlert(Alert.AlertType alertType, String message, String title) {
        Alert alert = new Alert(alertType, message);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.showAndWait();
    }
}
