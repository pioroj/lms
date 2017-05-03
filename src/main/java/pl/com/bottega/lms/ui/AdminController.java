package pl.com.bottega.lms.ui;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.lms.application.AdminModule;
import pl.com.bottega.lms.model.commands.AddBookCommand;
import pl.com.bottega.lms.model.commands.CreateUserCommand;

@RestController
public class AdminController {

	private AdminModule adminModule;

	public AdminController(AdminModule adminModule) {
		this.adminModule = adminModule;
	}

	@PutMapping("/book")
	public void createBook(@RequestBody AddBookCommand command) {
		adminModule.add(command);
	}

	@PutMapping("/user")
	public void createUser(@RequestBody CreateUserCommand command) {
		adminModule.createUser(command);
	}

}
