package com.book.Book.base;

import com.book.Book.exception.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;

@MappedSuperclass
public abstract class ServiceBase < Entity , ID> {
    @Autowired
    private RepositoryBase<Entity , ID> baseRepository;
    // service functions

    public long count() {
        return baseRepository.count();
    }
    @Autowired
    private MessageSource messageSource;
    public Entity findById(ID id) {
        String[] params = {id.toString()};
        String message = messageSource.getMessage("fieldNotFoundWithId", params, LocaleContextHolder.getLocale());
        return baseRepository.findById(id).orElseThrow(() ->new RecordNotFoundException(message));
    }
    public List<Entity> findALL() {
        return baseRepository.findAll();
    }
    public Entity insert(Entity entity) {
        return baseRepository.save(entity);
    }
    public List<Entity> insertAll(List<Entity> entities) {
        return baseRepository.saveAll(entities);
    }
    public Entity update (Entity entity) {
        return baseRepository.save(entity);
    }

    public void delete(ID id) {
        baseRepository.deleteById(id);
    }
}
