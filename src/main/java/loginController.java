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
import java.util.Iterator;
import java.util.List;

public class loginController {

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

        }
        else
        {
            promptField.setText("Login Failed!");

        }
        trans.commit();

    }

    @FXML
    void SignUpBtnClicked(ActionEvent event) {
        Stage stage = (Stage) signupBtn.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Signup Screen/signup.fxml"));
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




}