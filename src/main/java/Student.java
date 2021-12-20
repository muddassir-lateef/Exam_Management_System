import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Student extends User{

    @OneToMany
    private List<Exam> exams;

    public void addExam(Exam e){
        exams.add(e);
    }

    public List<Exam> getExams() {
        return exams;
    }
}