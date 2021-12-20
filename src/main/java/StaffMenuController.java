import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class StaffMenuController {

    @FXML
    private Button addExamBtn;

    @FXML
    private Button addVenueBtn;

    @FXML
    private Button assignPersonelBtn;

    @FXML
    private BorderPane borderpane;

    @FXML
    private Button scheduleExamBtn;

    @FXML
    private Button viewCodesBtn;

    @FXML
    private Button viewFeedbackBtn;

    @FXML
    void AddExamsClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/Add Exam Screen/addExam.fxml");

    }

    @FXML
    void AddVenueClicked(ActionEvent event) {

    }

    @FXML
    void AssignPersonnelClicked(ActionEvent event) {

    }

    @FXML
    void ScheduleExamsClicked(ActionEvent event) {

    }

    @FXML
    void viewCodesClicked(ActionEvent event) {

    }

    @FXML
    void viewFeedbackClicked(ActionEvent event) {

    }
    private void loadUI(String path){
        Parent root = null;
        try{
            root=FXMLLoader.load(getClass().getResource(path));

        }
        catch (IOException ex)
        {

        }
        borderpane.setCenter(root);
    }
}
