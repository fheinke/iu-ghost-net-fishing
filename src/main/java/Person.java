import jakarta.persistence.*;

@Entity
public class Person {
    @Id
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;

    // Constructor
    public Person() {
        super();
    }

    public Person(String name, String surname, String phoneNumber) {
        super();
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    // Getter / Setter
    public int getId() {
        return id;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Custom Methods
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getName().equals(this.name) && person.getSurname().equals(this.surname) && person.getPhoneNumber().equals(this.phoneNumber.replace(" ", ""));
        }
        return false;
    }

    public String getFullName() {
        return surname + ", " + name;
    }
}
