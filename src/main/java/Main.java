import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;


public class Main extends Application {
    public static void main(String[] args){
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(LoginDetails.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session  = sf.openSession();
        Transaction trans = session.beginTransaction();

        List usrs = session.createQuery("FROM LoginDetails" ).list();
        for(Iterator iter = usrs.iterator(); iter.hasNext(); ){
            LoginDetails usr =  (LoginDetails) iter.next();
            System.out.println("usr: " +usr.getUsername());
        }

       /* LoginDetails person = new LoginDetails();
        person.setUsername("Ma'am Behjat");
        person.setPassword("12345");
        session.save(person);*/

        /*Teacher teacher  = new Teacher();
        teacher.setName("Behjat Zuhaira");
        teacher.setLoginDetails(person);
        session.save(teacher);
        trans.commit();*/

        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginScreen/login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Examination System");
        stage.setScene(scene);
        stage.show();


    }
}
