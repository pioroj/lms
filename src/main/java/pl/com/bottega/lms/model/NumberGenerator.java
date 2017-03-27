package pl.com.bottega.lms.model;


public class NumberGenerator {

    private static long counter = 0L;

    public BookNumber generate() {
        return new BookNumber("nr-" + bookCounter());
    }

    private long bookCounter() {
        counter++;
        return counter;
    }

}
