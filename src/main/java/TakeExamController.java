import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class TakeExamController {

    @FXML
    private Button nextBtn;

    @FXML
    private ComboBox<String> optionComboBox;

    @FXML
    private Label questionNumberField;
    @FXML
    private Label prompt;

    @FXML
    private TextArea statementArea;

    @FXML
    private Button submitBtn;
    List<Question> questions=null;
    int n=0;
    int correct=0;

    @FXML
    public void initialize() {



       // typeComboBox.setItems(options);


        Singleton obj=Singleton.getInstance();

        questions=obj.exam.getQuestion();
        statementArea.setText(questions.get(n).getStatement());
        questionNumberField.setText((n+1)+" ");
        ObservableList<String> options1 = FXCollections.observableArrayList();
        List<Option> op=questions.get(n).getOptions();
        for(int i=0;i<op.size();i++)
        {
           options1.add(op.get(i).getStatement());
       }
        optionComboBox.setItems(options1);




    }


    @FXML
    void nextBtnClicked(ActionEvent event) {
        Singleton obj=Singleton.getInstance();

        questions=obj.exam.getQuestion();
        if(questions.get(n).getCorrectOption().equals(optionComboBox.getValue()))
        {
            correct++;
        }
        if(questions.size()==n+1)
        {
            prompt.setText("All Questions Answered.");
        }
        else {
            n++;
            questions = obj.exam.getQuestion();
            statementArea.setText(questions.get(n).getStatement());
            questionNumberField.setText((n + 1) + " ");
            ObservableList<String> options1 = FXCollections.observableArrayList();
            List<Option> op = questions.get(n).getOptions();
            for (int i = 0; i < op.size(); i++) {
                options1.add(op.get(i).getStatement());
            }
            optionComboBox.setItems(options1);
        }

    }

    @FXML
    void submitBtnClicked(ActionEvent event) {

    }

}
