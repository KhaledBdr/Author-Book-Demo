package com.book.Book.base;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean

public interface RepositoryBase<Entity , ID> extends JpaRepository<Entity, ID> {
}
