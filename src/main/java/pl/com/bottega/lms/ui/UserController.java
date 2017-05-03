package pl.com.bottega.lms.ui;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.bottega.lms.application.UserModule;
import pl.com.bottega.lms.model.BookNumber;

@RestController
public class UserController {

	private UserModule userModule;

	public UserController(UserModule userModule) {
		this.userModule = userModule;
	}

	@PostMapping("/{bookNumber}/{userId}/loan")
	public void orderBook(@PathVariable BookNumber bookNumber, @PathVariable Long userId) {
		userModule.orderBook(bookNumber, userId);
	}
}
