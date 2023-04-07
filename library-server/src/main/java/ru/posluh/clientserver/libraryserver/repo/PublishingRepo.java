package ru.posluh.clientserver.libraryserver.repo;

import ru.posluh.clientserver.libraryserver.entity.PublishingEntity;
import org.springframework.data.repository.CrudRepository;

public interface PublishingRepo extends CrudRepository<PublishingEntity, Long> {
}
