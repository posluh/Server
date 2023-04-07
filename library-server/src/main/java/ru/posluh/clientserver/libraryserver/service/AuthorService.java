package ru.posluh.clientserver.libraryserver.service;

import ru.posluh.clientserver.libraryserver.entity.AuthorEntity;
import ru.posluh.clientserver.libraryserver.exception.ValidationExceptionAuthor;
import ru.posluh.clientserver.libraryserver.repo.AuthorRepo;
import ru.posluh.clientserver.libraryserver.utils.ValidationAuthorUtils;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {
    private final AuthorRepo repo;

    public AuthorService(AuthorRepo repo) {
        this.repo = repo;
    }

    public AuthorEntity save(AuthorEntity author) {
        try {
            ValidationAuthorUtils.validationAuthor(author);
        } catch (ValidationExceptionAuthor e) {
            e.printStackTrace();
        }
        return repo.save(author);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<AuthorEntity> getAll() {
        return repo.findAll();
    }
}
