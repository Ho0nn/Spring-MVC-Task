package com.book.springtask.base;

import com.book.springtask.errors.RecordNotFoundException;
import jakarta.persistence.MappedSuperclass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;

import java.util.List;
import java.util.Optional;

@MappedSuperclass
public class BaseService<T extends BaseEntity<ID>,ID extends Number> {
    private final BaseRepo<T,ID>baseRepo;
    private MessageSource messageSource;

    public BaseService(BaseRepo<T,ID> baseRepo){
        this.baseRepo=baseRepo;
    }
    public T findById(ID id) {
        Optional<T> entity = baseRepo.findById(id);
        if (entity.isPresent()) return entity.get();
        else {
            String [] msgparam={id.toString()};
            String msg= messageSource.getMessage("validation.recordNotFound.message",msgparam, LocaleContextHolder.getLocale());
            throw new RecordNotFoundException(msg);
        }
    }
    public T getById(ID id) {
        return baseRepo.getById(id);
    }

    public List<T> findAll() {
        return baseRepo.findAll();
    }
    public void deleteById(ID id) {
        baseRepo.deleteById(id);
    }


}
