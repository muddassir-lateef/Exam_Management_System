import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class StudentMenuController {

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button registerExambtn;

    @FXML
    private Button takeExambtn;

    @FXML
    private Button viewEnrolledBtn;

    @FXML
    private Button viewResultsbtn;

    @FXML
    void registerExamBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/Register Exam Screen/register.fxml");


    }

    @FXML
    void takeExamBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/Take Exam Screen/takeExam.fxml");

    }

    @FXML
    void viewEnrolledBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/View Enrolled Screen/enrolledExams.fxml");

    }

    @FXML
    void viewResultsBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/View Results Screen/results.fxml");

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
