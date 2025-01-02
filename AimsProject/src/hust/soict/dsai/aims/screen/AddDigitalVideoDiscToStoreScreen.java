package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddDigitalVideoDiscToStoreScreen extends JFrame {

    private static Store store;

    public static void main(String[] args) {
        new AddDigitalVideoDiscToStoreScreen(store);
    }

    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super();
        AddDigitalVideoDiscToStoreScreen.store = store;
        initializeUI();
    }

    private void initializeUI() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        configureFrame();

        Platform.runLater(() -> loadFXML(fxPanel));
    }

    private void configureFrame() {
        this.setTitle("Add DVD");
        this.setSize(1024, 768);
        this.setVisible(true);
    }

    private void loadFXML(JFXPanel fxPanel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/screen/aims/screen/view/addDVD.fxml"));
            
            AddDVDScreenController controller = new AddDVDScreenController(store);
            loader.setController(controller);
            
            Parent root = loader.load();
            fxPanel.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
