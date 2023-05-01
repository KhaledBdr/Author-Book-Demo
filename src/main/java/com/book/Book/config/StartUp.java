package com.book.Book.config;

import com.book.Book.entity.Author;
import com.book.Book.entity.Book;
import com.book.Book.service.AuthorService;
import com.book.Book.service.BookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

//@Component
//@Transactional
public class StartUp implements CommandLineRunner {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) throws Exception {
        if (authorService.count() == 0) {
            Author author1 = new Author();
            author1.setName("Robert C. Martin");
            Author author2 = new Author();
            author2.setName("Frederick Brooks");
            Author author3 = new Author();
            author3.setName("Steve McConnell");
            authorService.insertAll(List.of(author1, author2, author3));

        }
        if (bookService.count() == 0) {
            Book b1 = new Book();
            b1.setTitle("Clean Code");
            b1.setPrice(20.0);
            b1.setAuthor(authorService.findById(1L));
            b1.setDescription(
                    "This is one of the best classic books for beginners and will teach you all" +
                            " tricks and patterns of writing good and clean code. Every code which" +
                            " runs is not a clean code. Most beginner programmer done this mistake," +
                            " they just try to solve the problem and hence forgets these factors to write" +
                            " clean and perfect professional code. A Clean Code should be properly readable," +
                            " and well structured so that it could be reused and debugged easily. ");
            b1.setPublishingDate(LocalDate.of(2000, 10, 20));

            Book b2 = new Book();
            b2.setTitle("The Mythical Man-month");
            b2.setPrice(100.0);
            b2.setAuthor(authorService.findById(2L));
            b2.setDescription(
                    "According to many software developers in the world, this book is literally a Bible to them." +
                            " This book will help you build a proper concept about software development," +
                            " estimates, project management, and troubles in software development. The main" +
                            " theme of this book is “Brooks’ Law ” which says “adding manpower to a late" +
                            " software project makes it later”. ");
            b2.setPublishingDate(LocalDate.of(2012, 10, 20));
            Book b3 = new Book();
            b3.setTitle("Code Complete (2 Edition)");
            b3.setPrice(150.0);
            b3.setAuthor(authorService.findById(3L));
            b3.setDescription(
                    "If you want to be a great software engineer you should read this book once." +
                            " This book provides the most useful practical guides to programming" +
                            " and helping developers write better software for more than a decade." +
                            " This book has a rare blend of classic and fully updated with revised" +
                            " leading-edge coding concepts and examples. With these proper concepts," +
                            " you can easily understand the art and science of software construction.");

            b3.setPublishingDate(LocalDate.of(2015, 10, 20));
            bookService.insertAll(List.of(b1 , b2 , b3));
        }
    }
}