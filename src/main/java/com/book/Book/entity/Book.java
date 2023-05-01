package com.book.Book.entity;

import com.book.Book.base.EntityBase;
import com.book.Book.validator.Price;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;

@NamedEntityGraph(name = "loadAuthor" ,attributeNodes = {@NamedAttributeNode("author")})
@Entity
@Table(name = "books")
public class Book extends EntityBase<Long> {
    @NotNull(message = "{Book.Validation.title}")
    private String title;
    private LocalDate publishingDate;
    @Price
    private double price;
    @Transient
    private double discount;
    private String image;

    @Column(length = 50000)
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "authorId")
    @NotNull(message = "{Book.Validation.author}")
    private Author author;

    public Book() {
    }
    public Book(String title, String image, String description, Author author) {
        this.title = title;
        this.image = image;
        this.description = description;
        this.author = author;
    }


    public Book(String title, LocalDate publishingDate, double price, String description, Author author) {
        this.title = title;
        this.publishingDate = publishingDate;
        this.price = price;
        this.description = description;
        this.author = author;
    }
    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }


    public void setImage(String image) {
        this.image = image;
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
//        this.publishingDate = publishingDate;
        this.publishingDate = LocalDate.now();
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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
    @PostLoad
    public void setDiscount(){
        discount = price * .25;
    }
    public double getDiscount() {
        return discount;
    }
}
