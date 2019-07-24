package sample;


import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.animations.Shake;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField LoginField;

    @FXML
    private PasswordField PasswordField;

    @FXML
    private Button GoIn;

    @FXML
    private Button SignUp;

    @FXML
    void initialize() {
        SignUp.setOnAction(event -> {
            System.out.println("Вы нажали кнопку зарегистрироваться");
           openNewScene("/sample/signup.fxml");
        });
        GoIn.setOnAction(event -> {
            String loginText = LoginField.getText().trim();
            String passText = PasswordField.getText().trim();
if(!loginText.equals("")&& !passText.equals("")){
    loginUser(loginText,passText);
}else{
    System.out.println("Login or Password is empty");
}

        });


    }

    private void loginUser(String loginText, String passText) {
        DatabaseHandler dbHandler = new DatabaseHandler();
        ResultSet rsSt = dbHandler.getUser(loginText,passText);
        int counter=0;
        while(true){
            try {
                if (!rsSt.next()) break;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            counter++;}
        if(counter>=1){
            System.out.println("Success");
            openNewScene("/sample/mainpage.fxml");

        }
        else {
            Shake userlogin = new Shake(LoginField);
            Shake userpas = new Shake(PasswordField);
            userlogin.playAnim();
            userpas.playAnim();
        }
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

