import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.IOException;

public class LoginController {

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
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(LoginDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session  = sf.openSession();
        Transaction trans = session.beginTransaction();

        LoginDetails usrs = (LoginDetails) session.createQuery("FROM LoginDetails U WHERE U.username = :userName AND U.password= :password").setParameter("userName", usrnameField.getText()).setParameter("password",pswdField.getText()).uniqueResult();

        if(usrs!=null)
        {
            promptField.setText("Login Successful!");
            Stage stage = (Stage) promptField.getScene().getWindow();
            if(usrs.getType().equals("Staff"))
            {
                SceneLoader.loadStage(stage,"Main Menu (Staff)/staffMenu.fxml");
            }
            else if(usrs.getType().equals("Teacher"))
            {
                SceneLoader.loadStage(stage,"Main Menu (Staff)/teacherMenu.fxml");
            }
            else if(usrs.getType().equals("Student"))
            {
                SceneLoader.loadStage(stage,"Main Menu (Staff)/studentMenu.fxml");
            }
            else if(usrs.getType().equals("Invigilator"))
            {
                SceneLoader.loadStage(stage,"Main Menu (Staff)/invigilatorMenu.fxml");
            }

        }
        else
        {
            promptField.setText("Login Failed!");

        }
        trans.commit();

    }

    @FXML
    void SignUpBtnClicked(ActionEvent event) {
        Stage stage = (Stage) promptField.getScene().getWindow();
        SceneLoader.loadStage(stage,"Signup Screen/signup.fxml");
    }




}