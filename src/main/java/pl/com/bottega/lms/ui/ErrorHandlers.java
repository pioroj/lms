package pl.com.bottega.lms.ui;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.com.bottega.lms.model.commands.InvalidCommandException;
import pl.com.bottega.lms.model.commands.Validatable;

@ControllerAdvice
public class ErrorHandlers {

	private static final String APPLICATION_JSON = "application/json";

	@ExceptionHandler(InvalidCommandException.class)
	public ResponseEntity<Validatable.ValidationErrors> handleInvalidCommandException(InvalidCommandException ex) {
		HttpHeaders headers = new HttpHeaders();
		headers.set(HttpHeaders.CONTENT_TYPE, APPLICATION_JSON);
		return new ResponseEntity<>(
				ex.getErrors(),
				headers,
				HttpStatus.UNPROCESSABLE_ENTITY
		);
	}

}
