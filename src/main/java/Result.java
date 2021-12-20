import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Result {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    int correct;
    int attempted;
    String Exam;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) {
        this.correct = correct;
    }

    public int getAttempted() {
        return attempted;
    }

    public void setAttempted(int attempted) {
        this.attempted = attempted;
    }

    public String getExam() {
        return Exam;
    }

    public void setExam(String exam) {
        Exam = exam;
    }
}
