package com.book.Book.controller;

import com.book.Book.dto.BookDTO;
import com.book.Book.dto.BookSearch;
import com.book.Book.entity.Book;
import com.book.Book.service.BookService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    //
    @GetMapping("/id/{id}")
    public Book getById (@PathVariable("id") Long id){
        return bookService.findById(id);
    }
    @GetMapping("/all")
    public List<Book> findALL() {
        return bookService.findALL();
    }
    @PostMapping("/add")
    public Book insert(@RequestBody @Valid Book book) {
        return bookService.insert(book);
    }
    @PostMapping("/filter")
    public List<Book> findUsingSpecification(@RequestBody BookSearch book) {
        return bookService.findUsingSpecification(book);
    }
    @PutMapping("/update")
    public Book update (@RequestBody Book book) {
        return bookService.update(book);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Long id) {
        bookService.delete(id);
    }


    @GetMapping("/alla")
    public List<Book> findALLUseAsync() throws ExecutionException, InterruptedException {
        return bookService.findAllUseComplete().get();
    }
}
