import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class TeacherMenuController {

    @FXML
    private Button addQuestionBtn;

    @FXML
    private BorderPane borderpane;

    @FXML
    void AddQuestionsClicked(ActionEvent event) {
        loadUI("Main Menu (Teacher)/Add Questions Screen/addQuestions.fxml");
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
