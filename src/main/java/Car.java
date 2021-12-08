import javax.persistence.Entity;

@Entity
public class Car {

    private int CarID;
    private int OwnerID;
    private String LicensePlate;
    private String Make;
    private int Model;

    public int getCarID() {
        return CarID;
    }

    public void setCarID(int carID) {
        CarID = carID;
    }

    public int getOwnerID() {
        return OwnerID;
    }

    public void setOwnerID(int ownerID) {
        OwnerID = ownerID;
    }

    public String getLicensePlate() {
        return LicensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        LicensePlate = licensePlate;
    }

    public String getMake() {
        return Make;
    }

    public void setMake(String make) {
        Make = make;
    }

    public int getModel() {
        return Model;
    }

    public void setModel(int model) {
        Model = model;
    }
}
