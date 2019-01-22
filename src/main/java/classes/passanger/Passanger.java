package classes.passanger;

public class Passanger {
    private int passangerId;
    private String firstName;
    private String lastName;
    private int trainId;

    public int getPassangerId() {
        return passangerId;
    }

    public void setPassangerId(int passangerId) {
        this.passangerId = passangerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getTrainId() {
        return trainId;
    }

    public Passanger() {
    }

    public Passanger(String firstName, String lastName, int trainId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainId = trainId;
    }

    public void setTrainId(int trainId) {
        this.trainId = trainId;
    }

    public Passanger(int passangerId, String firstName, String lastName, int trainId) {
        this.passangerId=passangerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.trainId=trainId;
    }

    @Override
    public String toString() {
        return "Passanger{" +
                "passangerId=" + passangerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", trainId=" + trainId +
                '}';
    }
}

