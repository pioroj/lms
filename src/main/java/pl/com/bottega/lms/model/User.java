package pl.com.bottega.lms.model;


public class User {

    private Long id;
    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public User(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return id.equals(user.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
