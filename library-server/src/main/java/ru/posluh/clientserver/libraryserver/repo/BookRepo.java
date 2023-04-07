package ru.posluh.clientserver.libraryserver.repo;

import ru.posluh.clientserver.libraryserver.entity.BookEntity;
import org.springframework.data.repository.CrudRepository;

public interface BookRepo extends CrudRepository<BookEntity, Long> {
    Iterable<BookEntity> findByTitle(String title);
}

