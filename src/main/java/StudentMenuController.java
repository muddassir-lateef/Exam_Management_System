import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

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
    void registerExamBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/Register Exam Screen/register.fxml");


    }

    @FXML
    void takeExamBtnClicked(ActionEvent event) {
        loadUI("Main Menu (Student)/Take Exam Screen/selectExam.fxml");
        Singleton obj=Singleton.getInstance();
        obj.borderPane=borderpane;
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
