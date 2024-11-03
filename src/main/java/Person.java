import jakarta.persistence.*;

import java.util.List;

@Entity
public class Person {
    @Id
    private int id;
    private String name;
    private String surname;
    private String phoneNumber;

    @OneToMany
    private List<Ghostnet> retrievingGhostnets;

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
    public void setId(int id) {
        this.id = id;
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

    public List<Ghostnet> getRetrievingGhostnets() {
        return retrievingGhostnets;
    }
    public void setRetrievingGhostnets(List<Ghostnet> retrievingGhostnets) {
        this.retrievingGhostnets = retrievingGhostnets;
    }

    // Custom Methods
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person) {
            Person person = (Person) obj;
            return person.getName().equals(this.name) && person.getSurname().equals(this.surname) && person.getPhoneNumber().equals(this.phoneNumber);
        }
        return false;
    }
}
