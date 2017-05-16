package pl.com.bottega.lms.model.commands;


import java.time.LocalDateTime;

public class AddBookCommand implements Validatable {

	private static final String REQUIRED_FIELD = "is a required field and can not be blank";

    private String title;
    private String author;
    private int year;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public void validate(ValidationErrors errors) {
        validateTitle(errors);
		validateAuthor(errors);
		validateYear(errors);
	}

	private void validateYear(ValidationErrors errors) {
		if (year > LocalDateTime.now().getYear())
			errors.add("year", "can not be in future");
	}

	private void validateAuthor(ValidationErrors errors) {
		if (author == null) {
			errors.add("author", REQUIRED_FIELD);
			return;
		}
		if (author.trim().isEmpty())
			errors.add("author", REQUIRED_FIELD);
	}

	private void validateTitle(ValidationErrors errors) {
		if (title == null) {
			errors.add("title", REQUIRED_FIELD);
			return;
		}
		if (title.trim().isEmpty())
			errors.add("title", REQUIRED_FIELD);
	}
}
