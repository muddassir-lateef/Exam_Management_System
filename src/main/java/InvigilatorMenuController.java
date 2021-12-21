import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class InvigilatorMenuController {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button submitFeedbackBtn;

    @FXML
    private Button viewDutiesBtn;

    @FXML
    private Button logoutbtn;


    @FXML
    void logOutBtnClicked(ActionEvent event) {
        Stage stage = (Stage) borderpane.getScene().getWindow();
        Main.loadStage(stage,"LoginScreen/login.fxml");
    }


    @FXML
    void submitFeedbackBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Invigilator)/Submit Feedback Screen/feedback.fxml");

    }
    
    private void loadUI(String path){
        Parent root = null;
        try{
            root= FXMLLoader.load(getClass().getResource(path));

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());

        }
        borderpane.setCenter(root);
    }

}
