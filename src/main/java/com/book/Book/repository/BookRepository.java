package com.book.Book.repository;

import com.book.Book.base.RepositoryBase;
import com.book.Book.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends RepositoryBase<Book, Long> , JpaSpecificationExecutor<Book> {
    @Override
    @EntityGraph(value = "loadAuthor")
    List<Book> findAll();
    @Override
    @EntityGraph(value = "loadAuthor")
    Optional<Book> findById(Long id);

    @Override
    @EntityGraph(value = "loadAuthor")
    List<Book> findAll(Specification<Book> specification);
    Optional<Book> findByTitle (String title);
}
