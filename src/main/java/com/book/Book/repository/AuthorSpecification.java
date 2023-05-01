package com.book.Book.repository;

import com.book.Book.dto.AuthorSearch;
import com.book.Book.entity.Author;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AuthorSpecification implements Specification<Author> {
    final private AuthorSearch authorSearch;

    public AuthorSpecification(AuthorSearch authorSearch) {
        this.authorSearch = authorSearch;
    }

    @Override
    public Predicate toPredicate(Root<Author> root, CriteriaQuery<?> query, CriteriaBuilder c) {
        List<Predicate> predicateList = new ArrayList<>();
        if (authorSearch.getName() != null && !authorSearch.getName().isEmpty())
            predicateList.add(c.like(c.lower(root.get("name")) ,  "%" + authorSearch.getName().toLowerCase() + "%"));
        if (authorSearch.getEmail() != null && !authorSearch.getEmail().isEmpty())
            predicateList.add(c.like(root.get("email") , "%" + authorSearch.getEmail() +"%"));

        return c.and(predicateList.toArray(new Predicate[0]));
    }
}
