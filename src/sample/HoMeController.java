package sample;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;

public class HoMeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView IMAGE;

    @FXML
    void initialize() {
        assert IMAGE != null : "fx:id=\"IMAGE\" was not injected: check your FXML file 'mainpage.fxml'.";

    }
}
