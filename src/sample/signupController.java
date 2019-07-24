package sample;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class signupController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button SignUp;
    @FXML
    private Button Back;

    @FXML
    void initialize() {
        DatabaseHandler dbHandler = new DatabaseHandler();
       SignUp.setOnAction(event -> {
           dbHandler.signUpUser(LoginField.getText(),PasswordField.getText());
           System.out.println("Вы зарегестрированы");
           openNewScene("/sample/sample.fxml");
       });
       Back.setOnAction(event-> {
           openNewScene("/sample/sample.fxml");
          /* Back.getScene().getWindow().hide();

           FXMLLoader loader = new FXMLLoader();
           loader.setLocation(getClass().getResource("/sample/sample.fxml"));
           try{loader.load();}catch(IOException e){e.printStackTrace();}
           Parent root = loader.getRoot();
           Stage stage = new Stage();
           stage.setScene(new Scene(root));
           stage.showAndWait();*/
       });

    }
    public void openNewScene(String window){
        SignUp.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(window));
        try{loader.load();}catch(IOException e){e.printStackTrace();}
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.showAndWait();
    }
}
