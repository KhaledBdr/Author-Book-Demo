package com.book.Book.service;

import com.book.Book.base.ServiceBase;
import com.book.Book.dto.BookSearch;
import com.book.Book.entity.Book;
import com.book.Book.exception.DuplicatedFieldException;
import com.book.Book.repository.BookRepository;
import com.book.Book.repository.BookSpecification;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

@Service
public class BookService extends ServiceBase<Book , Long> {
    final private BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book insert(Book book) {
        if (book.getId() != null) throw new RuntimeException();
        Optional<Book> isExists = bookRepository.findByTitle(book.getTitle());
        if (isExists.isPresent()){
            throw new DuplicatedFieldException("this Book is already exists with id " + isExists.get().getId());
        }
        return super.insert(book);
    }

    public Book update (Book book) {
        Book Book1 = findById(book.getId());
        if (book.getTitle() != null) {
            Book1.setTitle(book.getTitle());
        }
        return super.insert(book);
    }


    public List<Book> findUsingSpecification(BookSearch bookSearch) {

        BookSpecification bookSpecification = new BookSpecification(bookSearch);
        return bookRepository.findAll(bookSpecification);
    }

    @Async
    public CompletableFuture<List<Book>> findAllUseComplete () {
        return CompletableFuture.completedFuture(bookRepository.findAll());
    }
}
