package com.book.Book.repository;

import com.book.Book.dto.BookSearch;
import com.book.Book.entity.Author;
import com.book.Book.entity.Book;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class BookSpecification implements Specification<Book>{
    final private BookSearch bookSearch;

    public BookSpecification(BookSearch bookSearch) {
        this.bookSearch = bookSearch;
    }

    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicateList = new ArrayList<>();

        if (bookSearch.getTitle() != null && !bookSearch.getTitle().isEmpty()){
            predicateList.add(cb.like(root.get("title") ,"%" + bookSearch.getTitle() + "%"));
        }

        if (bookSearch.getAuthor() != null && bookSearch.getAuthor().getId() > 0) {
            predicateList.add(cb.equal(root.get("author").get("id"), bookSearch.getAuthor().getId()));
        }
        return cb.and(predicateList.toArray(new Predicate[0]));
    }
}
