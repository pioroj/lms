package pl.com.bottega.lms.application.implementation;


import org.springframework.transaction.annotation.Transactional;
import pl.com.bottega.lms.application.UserManagement;
import pl.com.bottega.lms.model.UserRepository;
import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;
import pl.com.bottega.lms.model.User;

@Transactional
public class StandardUserManagement implements UserManagement {

    private UserRepository userRepository;

    public StandardUserManagement(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(CreateUserCommand cmd) {
        User user = new User(cmd);
        userRepository.put(user);
    }

    @Override
    public void updateUser(UpdateUserCommand cmd) {

    }

    @Override
    public void deleteUser(Long userId) {

    }

    @Override
    public User get(Long userId) {
        return userRepository.get(userId);
    }
}
