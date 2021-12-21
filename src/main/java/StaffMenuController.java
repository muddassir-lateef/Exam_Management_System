import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    private Button logoutbtn;


    @FXML
    void logOutBtnClicked(ActionEvent event) {
        Stage stage = (Stage)logoutbtn.getScene().getWindow();
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

    }



    @FXML
    void AddExamsClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/Add Exam Screen/addExam.fxml");

    }

    @FXML
    void AddVenueClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/Add Venue Screen/addVenue.fxml");
    }

    @FXML
    void AssignPersonnelClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/Assign Personnel Screen/assignPersonnel.fxml");

    }

    @FXML
    void ScheduleExamsClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/Schedule Exam Screen/scheduleExam.fxml");

    }

    @FXML
    void viewCodesClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/View Registration Codes Screen/registrationCodes.fxml");

    }

    @FXML
    void viewFeedbackClicked(ActionEvent event) {
        loadUI("Main Menu (Staff)/View Exam FeedBack Screen/examFeedback.fxml");

    }
    private void loadUI(String path){
        Parent root = null;
        try{
            root=FXMLLoader.load(getClass().getResource(path));

        }
        catch (IOException ex)
        {
            System.out.println(ex.getMessage());

        }
        borderpane.setCenter(root);
    }
}
