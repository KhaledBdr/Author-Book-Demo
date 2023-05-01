package com.book.Book.dto;

import com.book.Book.entity.Author;
import com.book.Book.entity.Book;
import jakarta.persistence.*;

import java.time.LocalDate;

public class BookDTO {
    private Long id;
    private String title;
    private LocalDate publishingDate;
    private double price;
    private String description;

    public BookDTO() {
    }
    public BookDTO(Book book) {
        this.description = book.getDescription();
        this.id = book.getId();
        this.title = book.getTitle();
        this.price = book.getPrice();
        this.publishingDate = book.getPublishingDate();
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getPublishingDate() {
        return publishingDate;
    }

    public void setPublishingDate(LocalDate publishingDate) {
        this.publishingDate = publishingDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
