package ru.posluh.clientserver.libraryserver.service;

import ru.posluh.clientserver.libraryserver.entity.BookEntity;
import ru.posluh.clientserver.libraryserver.exception.ValidationExceptionAuthor;
import ru.posluh.clientserver.libraryserver.exception.ValidationExceptionBook;
import ru.posluh.clientserver.libraryserver.exception.ValidationExceptionPublishing;
import ru.posluh.clientserver.libraryserver.repo.BookRepo;
import ru.posluh.clientserver.libraryserver.utils.ValidationBookUtils;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    private final BookRepo repo;

    public BookService(BookRepo repo) {
        this.repo = repo;
    }

    public BookEntity save(BookEntity book) {
        try {
            ValidationBookUtils.validationBook(book);
        } catch (ValidationExceptionPublishing | ValidationExceptionBook | ValidationExceptionAuthor e) {
            e.printStackTrace();
        }
        return repo.save(book);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<BookEntity> getAll() {
        return repo.findAll();
    }

    public Iterable<BookEntity> getBookByName(String title) {
        return repo.findByTitle(title);
    }
}
