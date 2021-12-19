
import javax.persistence.*;

@Entity
public class Person {

    @OneToOne
    private Car car;
    @Id @GeneratedValue
    private int PersonID;
    private String name;
    private String surname;

    public Car getCar() {
        return car;
    }

    public int getPersonID() {

        return PersonID;
    }

    public void setPersonID(int personID) {

        PersonID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {

        this.surname = surname;
    }

    public void setCar(Car car2) {
        car = car2;
    }
}
