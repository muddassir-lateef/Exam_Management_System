import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main extends Application {
    public static void main(String[] args){
        Configuration con = new Configuration();
        con.configure().addAnnotatedClass(Person.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session  = sf.openSession();
        Transaction trans = session.beginTransaction();

        Car car = new Car();
        car.setLicensePlate("ASZ123");
        session.save(car);

        Person person = new Person();
        person.setCar(car);
        person.setName("Sufwan");
        person.setSurname("Amir");
        session.save(person);
        trans.commit();

        launch();

    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();


    }
}
