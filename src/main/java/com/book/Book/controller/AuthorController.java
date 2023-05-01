package com.book.Book.controller;

import com.book.Book.dto.AuthorSearch;
import com.book.Book.entity.Author;
import com.book.Book.service.AuthorService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    //
    @GetMapping("/id/{id}")
    public Author getById (@PathVariable("id") Long id){
        return authorService.findById(id);
    }
    @GetMapping("/all")
    public List<Author> findALL() {
        return authorService.findALL();
    }
    @PostMapping("/add")
    public Author insert(@RequestBody @Valid Author author) {
        return authorService.insert(author);
    }
    @PostMapping("/filter")
    public List<Author> filter(@RequestBody @Valid AuthorSearch authorSearch) {
        return authorService.filter(authorSearch);
    }
    @GetMapping("/email/{email}")
    public Author filterByEmail(@PathVariable("email") @Email String email) {
        return authorService.findByEmail(email);
    }
    @GetMapping("/count")
    public long count(){
        return authorService.count();
    }
    @PutMapping("/update")
    public Author update (@RequestBody Author author) {
        return authorService.update(author);
    }

    @DeleteMapping("/delete/{id}")
    public void delete (@PathVariable Long id) {
        authorService.delete(id);
    }
}
