import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class SignupController {

    @FXML
    private Button backbtn;

    @FXML
    private TextField namefield;

    @FXML
    private Text promptField;

    @FXML
    private PasswordField pswdfield;

    @FXML
    private TextField regCodeField;

    @FXML
    private Button signupbtn;

    @FXML
    private TextField usernamefield;

    @FXML
    void backBtnClicked(ActionEvent event) {
        Stage stage = (Stage) promptField.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginScreen/login.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Examination System");
        stage.setScene(scene);
        stage.show();
    }///some comment

}
