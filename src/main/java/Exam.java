import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exam {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private int Id;
    private String Name;
    private String Course;


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }
}
