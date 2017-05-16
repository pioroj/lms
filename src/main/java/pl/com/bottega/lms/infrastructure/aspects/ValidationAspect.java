package pl.com.bottega.lms.infrastructure.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import pl.com.bottega.lms.model.commands.InvalidCommandException;
import pl.com.bottega.lms.model.commands.Validatable;
import pl.com.bottega.lms.model.commands.Validatable.ValidationErrors;

@Component
@Aspect
public class ValidationAspect {

	@Before("execution(* pl.com.bottega.lms.application..*.*(..)) && args(validatable,..)")
	public void validate(Validatable validatable) {
		ValidationErrors errors = new ValidationErrors();
		validatable.validate(errors);
		if (!errors.isValid()) {
			throw new InvalidCommandException(errors);
		}
	}

}
