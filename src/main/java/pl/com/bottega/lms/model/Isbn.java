package pl.com.bottega.lms.model;


public class Isbn {

    private String isbnNumber;

    public Isbn(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getIsbnNumber() {
        return isbnNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Isbn)) return false;

        Isbn isbn = (Isbn) o;

        return isbnNumber.equals(isbn.isbnNumber);
    }

    @Override
    public int hashCode() {
        return isbnNumber.hashCode();
    }
}
