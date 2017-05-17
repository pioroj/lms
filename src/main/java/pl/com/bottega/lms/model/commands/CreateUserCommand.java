package pl.com.bottega.lms.model.commands;


public class CreateUserCommand implements Validatable {

    private String name;
    private String surname;
    private String phoneNumber;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateName(errors);
		validateSurname(errors);
		validatePhoneNumber(errors);
		validateEmail(errors);
	}

	private void validateEmail(ValidationErrors errors) {
		if (email == null) {
			errors.add("email", REQUIRED_FIELD);
			return;
		}
		if (email.trim().isEmpty())
			errors.add("email", REQUIRED_FIELD);
	}

	private void validatePhoneNumber(ValidationErrors errors) {
		if (phoneNumber == null) {
			errors.add("phoneNumber", REQUIRED_FIELD);
			return;
		}
		if (phoneNumber.trim().isEmpty())
			errors.add("phoneNumber", REQUIRED_FIELD);
	}

	private void validateSurname(ValidationErrors errors) {
		if (surname == null) {
			errors.add("surname", REQUIRED_FIELD);
			return;
		}
		if (surname.trim().isEmpty())
			errors.add("surname", REQUIRED_FIELD);
	}

	private void validateName(ValidationErrors errors) {
		if (name == null) {
			errors.add("name", REQUIRED_FIELD);
			return;
		}
		if (name.trim().isEmpty())
			errors.add("name", REQUIRED_FIELD);
	}
}
