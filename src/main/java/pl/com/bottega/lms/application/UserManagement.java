package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.commands.CreateUserCommand;
import pl.com.bottega.lms.model.commands.UpdateUserCommand;
import pl.com.bottega.lms.model.User;

public interface UserManagement {

    void createUser(CreateUserCommand cmd);

    void updateUser(UpdateUserCommand cmd);

    void deleteUser(Long userId);

    User get(Long userId);

}
