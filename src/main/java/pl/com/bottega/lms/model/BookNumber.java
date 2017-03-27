package pl.com.bottega.lms.model;


import java.io.Serializable;

public class BookNumber implements Serializable {

    private String number;

    public BookNumber(String number) {
        this.number = number;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookNumber)) return false;

        BookNumber that = (BookNumber) o;

        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }
}
