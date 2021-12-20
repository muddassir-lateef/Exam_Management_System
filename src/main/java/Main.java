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
