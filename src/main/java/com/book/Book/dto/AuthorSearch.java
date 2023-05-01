package com.book.Book.dto;

import com.book.Book.base.EntityBase;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.Formula;

public class AuthorSearch {
        private String name;
        private String email;
        public AuthorSearch(String name, String email) {
            this.name = name;
            this.email = email;
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
    }
