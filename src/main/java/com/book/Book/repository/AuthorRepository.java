package com.book.Book.repository;

import com.book.Book.base.RepositoryBase;
import com.book.Book.entity.Author;
import com.book.Book.entity.Book;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends RepositoryBase<Author , Long> , JpaSpecificationExecutor<Author>{
    @Override
    List<Author> findAll(Specification<Author> specification);
    Optional<Author> findByEmail(String email);
}
