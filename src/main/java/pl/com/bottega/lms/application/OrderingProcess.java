package pl.com.bottega.lms.application;


import pl.com.bottega.lms.model.commands.OrderBookCommand;
import pl.com.bottega.lms.model.commands.ReturnBookCommand;

public interface OrderingProcess {

    void orderBook(OrderBookCommand cmd);

    void returnBook(ReturnBookCommand cmd);

}
