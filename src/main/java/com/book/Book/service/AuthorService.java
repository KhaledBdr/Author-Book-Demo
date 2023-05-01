package com.book.Book.service;

import com.book.Book.base.ServiceBase;
import com.book.Book.dto.AuthorSearch;
import com.book.Book.entity.Author;
import com.book.Book.exception.DuplicatedFieldException;
import com.book.Book.exception.RecordNotFoundException;
import com.book.Book.repository.AuthorRepository;
import com.book.Book.repository.AuthorSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AuthorService extends ServiceBase<Author , Long> {
    final private AuthorRepository authorRepository;
    final private MessageSource messageSource;
    Logger logger = LoggerFactory.getLogger(AuthorService.class);
    public AuthorService(AuthorRepository authorRepository, MessageSource messageSource) {
        this.authorRepository = authorRepository;
        this.messageSource = messageSource;
    }
    // service functions

    @Override
    @Cacheable(value = "allAuthor" , key = "#root.methodName" )
    public List<Author> findALL() {
        return super.findALL();
    }
    @Override
    @Cacheable(value = "count" , key = "#root.methodName" )
    public long count() {
        return super.count();
    }
    @Override
    @CacheEvict(value = {"count" , "allAuthor"} , key = "#root.methodName" , allEntries = true)
    public Author insert(Author author) {
        if (author.getId() != null) throw new RuntimeException();
        Optional<Author> byEmail = authorRepository.findByEmail(author.getEmail());
        if (byEmail.isPresent()){
            logger.error("try create author with an email which is already exists. email : " + author.getEmail());
            throw new DuplicatedFieldException(
                    messageSource.getMessage("emailExists" ,null, LocaleContextHolder.getLocale())
            );
        }
        logger.info("new Author added" + author.toString());
        return super.insert(author);
    }

    public Author update (Author author) {
        Author author1 = findById(author.getId());
        if (author.getName() != null) {
            author1.setName(author.getName());
        }
        return super.update(author);
    }

    public List<Author> filter(AuthorSearch authorSearch){
        AuthorSpecification authorSpecification = new AuthorSpecification(authorSearch);
        return authorRepository.findAll(authorSpecification);
    }
    public Author findByEmail(String email) {
        String[] param = {email};
        String emailNotFound = messageSource.getMessage("emailNotFound", param, LocaleContextHolder.getLocale());

        return authorRepository
                .findByEmail(email)
                .orElseThrow(
                        ()-> new RecordNotFoundException(emailNotFound)
                );
    }
}
