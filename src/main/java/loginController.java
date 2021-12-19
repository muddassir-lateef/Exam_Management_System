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

public class loginController {

    @FXML
    private Button loginBtn;

    @FXML
    private Text promptField;

    @FXML
    private PasswordField pswdField;

    @FXML
    private Button signupBtn;

    @FXML
    private TextField usrnameField;

    @FXML
    void LoginBtnClicked(ActionEvent event) {

    }

    @FXML
    void SignUpBtnClicked(ActionEvent event) {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Signup Screen/signup.fxml"));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
        stage.setTitle("Examination System");
        stage.setScene(scene);
        stage.show();

    }




}