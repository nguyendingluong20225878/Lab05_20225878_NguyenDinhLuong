package hust.soict.dsai.aims.screen;

import java.net.URL;
import java.util.ResourceBundle;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AddTrackScreenController {
    private CompactDisc CD;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnSaveTrack;

    @FXML
    private TextField tfLength;

    @FXML
    private TextField tfTitle;

    private boolean allFieldsFilled = false;

    // Constructor nhận đối tượng CompactDisc
    public AddTrackScreenController(CompactDisc CD) {
        super();
        this.CD = CD;
    }

    // Xử lý khi người dùng nhấn nút Save Track
    @FXML
    void btnSaveTrackPressed(ActionEvent event) {
        String title = tfTitle.getText();
        int length = 0;

        // Kiểm tra nếu trường độ dài hợp lệ
        try {
            length = Integer.parseInt(tfLength.getText());
            if (length <= 0) {
                throw new NumberFormatException("Length must be greater than 0");
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Failed to parse length: " + e.getMessage());
            alert.setTitle("Invalid input");
            alert.setHeaderText(null);
            alert.showAndWait();
            return;
        }

        // Tạo Track mới và thêm vào CD
        Track track = new Track(title, length);
        CD.addTrack(track);

        // Xóa các trường nhập liệu
        tfTitle.clear();
        tfLength.clear();

        // Hiển thị thông báo thành công
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Track has been added!");
        alert.setTitle("Success");
        alert.setHeaderText(null);
        alert.showAndWait();
    }

    // Kiểm tra khi các trường được nhập liệu
    @FXML
    void initialize() {
        btnSaveTrack.setDisable(true);

        tfTitle.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
        tfLength.textProperty().addListener((observable, oldValue, newValue) -> checkFieldsFilled());
    }

    // Kiểm tra tất cả các trường có được điền đầy đủ
    private void checkFieldsFilled() {
        // Nếu tất cả các trường đều không rỗng, kích hoạt nút lưu
        if (!tfTitle.getText().isEmpty() && !tfLength.getText().isEmpty()) {
            allFieldsFilled = true;
        } else {
            allFieldsFilled = false;
        }
        btnSaveTrack.setDisable(!allFieldsFilled);
    }
}
