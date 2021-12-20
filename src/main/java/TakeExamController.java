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
    private TextArea statementArea;

    @FXML
    private Button submitBtn;
    @FXML
    public void initialize() {



       // typeComboBox.setItems(options);

        ObservableList<String> options1 = FXCollections.observableArrayList();
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Exam.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();
        List exams = session.createQuery("FROM Exam").list();
        for (Iterator iter = exams.iterator(); iter.hasNext(); ) {

            Exam exm = (Exam) iter.next();
            options1.add(exm.getId() + ". " + exm.getName());

        }
        trans.commit();

  //      ExamsComboBox.setItems(options1);


    }
    @FXML
    void nextBtnClicked(ActionEvent event) {

    }

    @FXML
    void submitBtnClicked(ActionEvent event) {

    }

}
