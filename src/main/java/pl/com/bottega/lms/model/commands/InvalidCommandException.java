package pl.com.bottega.lms.model.commands;

import static pl.com.bottega.lms.model.commands.Validatable.*;

public class InvalidCommandException extends RuntimeException {

	private ValidationErrors errors;

	public InvalidCommandException(ValidationErrors errors) {
		this.errors = errors;
	}

	public ValidationErrors getErrors() {
		return errors;
	}
}
