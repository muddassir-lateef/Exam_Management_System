
import java.io.IOException;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.paint.Color;

public class Main extends Application {
    private static double xOffset = 0;
    private static double yOffset = 0;
    public static void main(String[] args){


        launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
      //  FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("LoginScreen/login.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen/login.fxml"));
        stage.initStyle(StageStyle.TRANSPARENT);
        root.setStyle("-fx-background-radius: 6;" );
        stage.setTitle("Examination System");
      //  stage.initStyle(StageStyle.UNDECORATED);


        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });

        //move around here
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                stage.setX(event.getScreenX() - xOffset);
                stage.setY(event.getScreenY() - yOffset);
            }
        });
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        stage.setScene(scene);

        stage.show();

    }
    public static void loadStage(Stage stage,String path)
    {
        try {


            Parent root = FXMLLoader.load(Main.class.getResource(path));
            stage.setTitle("Examination System");
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset = event.getSceneX();
                    yOffset = event.getSceneY();
                }
            });

            //move around here
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    stage.setX(event.getScreenX() - xOffset);
                    stage.setY(event.getScreenY() - yOffset);
                }
            });
            Scene scene = new Scene(root);
            stage.setScene(scene);

            stage.show();
        }
        catch (Exception e)
        {

        }


    }
}