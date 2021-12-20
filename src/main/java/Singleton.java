import javafx.scene.layout.BorderPane;

public class Singleton {
    private static Singleton single_instance = null;

    // Declaring a variable of type String
    Exam exam;
    Student currStud;
    BorderPane borderPane;

    private Singleton()
    {

    }
    // Static method
    // Static method to create instance of Singleton class
    public static Singleton getInstance()
    {
        if (single_instance == null)
            single_instance = new Singleton();

        return single_instance;
    }
}
