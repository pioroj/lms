package pl.com.bottega.lms.model;


public interface UserRepository {

    void put(User user);

    User get(Long userId);

}
