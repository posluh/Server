package ru.posluh.clientserver.libraryserver.repo;

import ru.posluh.clientserver.libraryserver.entity.AuthorEntity;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepo extends CrudRepository<AuthorEntity, Long> {
}
