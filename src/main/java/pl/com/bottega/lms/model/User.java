package pl.com.bottega.lms.model;

import pl.com.bottega.lms.model.commands.CreateUserCommand;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public User(CreateUserCommand cmd) {
        this.name = cmd.getName();
        this.surname = cmd.getSurname();
        this.email = cmd.getEmail();
        this.phoneNumber = cmd.getPhoneNumber();
    }

    User() {}

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }
}
