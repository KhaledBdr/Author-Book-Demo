package com.book.Book.service;


import com.book.Book.entity.Book;
import com.book.Book.repository.BookRepository;
import jakarta.persistence.Access;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class TestSchedule {
    int i = 0;
    Logger logger = LoggerFactory.getLogger(TestSchedule.class);
    @Autowired
    private BookRepository bookRepository;
    @Scheduled(fixedRate = 200)
    public void getAllBookPrices() {
        List<Book> books = bookRepository.findAll();
        double price = 0;
        for (Book book : books) {
            price += book.getPrice();
        }
        logger.info("this is the time number " + ++i + " and price is  " + price);
    }
}
