package pl.com.bottega.lms.model;


import java.util.UUID;

public class NumberGenerator {

    public BookNumber generate() {
        return new BookNumber("nr-" + UUID.randomUUID().toString());
    }

}
