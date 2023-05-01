package com.book.Book.entity;

import com.book.Book.base.EntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


@Entity
@Table(name = "authors")
public class Author extends EntityBase<Long> {

    @NotNull(message = "{Author.Validation.name}")
    private String name;
    @Email(message ="{Author.Validation.email}")
    private String email;

    private String image;
    @Formula("(Select count(*) from books b where b.author_id = id)")
    private int ownBooks;

    public Author() {
    }
    public Author(String name, String email, String image) {
        this.name = name;
        this.email = email;
        this.image = image;
    }

    public Author(String name, String email) {
        this.name = name;
        this.email = email;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setOwnBooks(int ownBooks) {
        this.ownBooks = ownBooks;
    }
    public int getOwnBooks() {
        return ownBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Author{" +
                "id='" +super.getId()+ '\'' +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
