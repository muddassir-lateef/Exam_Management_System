
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
        import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
        import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class SelectExamController {

    @FXML
    private ComboBox<String> examComboBox;

    @FXML
    private Button takeExamBtn;
    @FXML
    public void initialize() {


        ObservableList<String> options1 = FXCollections.observableArrayList();
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Exam.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        Transaction trans = session.beginTransaction();

        Singleton obj=Singleton.getInstance();
        int id=obj.currStud.getID();

        List results = session.createQuery("FROM Result where studentID = :temp").setParameter("temp", id).list();


        Student stu = (Student) session.createQuery("FROM Student where ID = : tempID").setParameter("tempID", id).uniqueResult();
        List exams = stu.getExams();
        for (Iterator iter = exams.iterator(); iter.hasNext(); ) {

            Exam exm = (Exam) iter.next();
            boolean hasGiven = false;
            for (Iterator iter2 = results.iterator(); iter2.hasNext(); ) {

                Result res = (Result) iter2.next();
                if (exm.getId() == res.getExamID()){
                    hasGiven = true;
                }
            }

            if(! hasGiven) {
                options1.add(exm.getId() + ". " + exm.getName());
            }

        }
        trans.commit();

        examComboBox.setItems(options1);


    }
    @FXML
    void takeExamClicked(ActionEvent event) {

        if (examComboBox.getValue() != null )
        {


            String[] temp1 = examComboBox.getValue().split(". ");
            int eid=Integer.parseInt(temp1[0]);

            Configuration con = new Configuration();
            con.configure().addAnnotatedClass(Exam.class);
            SessionFactory sf = con.buildSessionFactory();
            Session session = sf.openSession();
            Transaction trans = session.beginTransaction();
            Exam e=session.get(Exam.class,eid);
            Singleton obj=Singleton.getInstance();
            obj.exam=e;
            trans.commit();
            loadUI("Main Menu (Student)/Take Exam Screen/takeExam.fxml");
        }

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
        Singleton obj=Singleton.getInstance();
        obj.borderPane.setCenter(root);
    }

}
