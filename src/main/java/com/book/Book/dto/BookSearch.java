package com.book.Book.dto;

import com.book.Book.entity.Author;
import com.book.Book.validator.Price;
import jakarta.persistence.*;

import java.time.LocalDate;

public class BookSearch {
    private String title;
    private LocalDate publishingDate;
    private double minPrice;
    private double maxPrice;
    private Author author;
    public BookSearch(String title, LocalDate publishingDate, double minPrice , double maxPrice, Author author) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.author = author;
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

    public double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(double minPrice) {
        this.minPrice = minPrice;
    }

    public double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(double maxPrice) {
        this.maxPrice = maxPrice;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
