package pl.com.bottega.lms.acceptance;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import pl.com.bottega.lms.application.UserManagement;
import pl.com.bottega.lms.model.User;
import pl.com.bottega.lms.model.UserRepository;
import pl.com.bottega.lms.model.commands.CreateUserCommand;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserManagementTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserManagement userManagement;

    @Test
    public void shouldAddUser() {
        CreateUserCommand createUserCommand = new CreateUserCommand();
        createUserCommand.setName("Jan");
        createUserCommand.setSurname("Nowak");
        createUserCommand.setEmail("jan@jany.pl");
        createUserCommand.setPhoneNumber("123456789");

        Long userId = userManagement.createUser(createUserCommand);

        Assertions.assertThat(userRepository.get(userId).getName()).isEqualTo("Jan");
    }

}
