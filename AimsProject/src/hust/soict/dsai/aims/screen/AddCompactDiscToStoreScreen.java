package hust.soict.dsai.aims.screen;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCompactDiscToStoreScreen extends JFrame {

    private static Store store;

    public static void main(String[] args) {
        new AddCompactDiscToStoreScreen(store);
    }

    public AddCompactDiscToStoreScreen(Store store) {
        super();
        AddCompactDiscToStoreScreen.store = store;

        initializeUI();
    }

    private void initializeUI() {
        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);

        configureFrame();

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                loadFXML(fxPanel);
            }
        });
    }

    private void configureFrame() {
        this.setTitle("Add DVD");
        this.setSize(1024, 768);
        this.setVisible(true);
    }

    private void loadFXML(JFXPanel fxPanel) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/screen/aims/screen/addCD.fxml"));

            AddCDScreenController controller = new AddCDScreenController(store);
            loader.setController(controller);

            Parent root = loader.load();
            fxPanel.setScene(new Scene(root));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
