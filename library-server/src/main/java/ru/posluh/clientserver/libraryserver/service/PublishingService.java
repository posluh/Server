package ru.posluh.clientserver.libraryserver.service;

import ru.posluh.clientserver.libraryserver.entity.PublishingEntity;
import ru.posluh.clientserver.libraryserver.exception.ValidationExceptionPublishing;
import ru.posluh.clientserver.libraryserver.repo.PublishingRepo;
import ru.posluh.clientserver.libraryserver.utils.ValidationPublishingUtils;
import org.springframework.stereotype.Service;

@Service
public class PublishingService {
    private final PublishingRepo repo;

    public PublishingService(PublishingRepo repo) {
        this.repo = repo;
    }

    public PublishingEntity save(PublishingEntity publishing) {
        try {
            ValidationPublishingUtils.validationPublishing(publishing);
        } catch (ValidationExceptionPublishing e) {
            e.printStackTrace();
        }
        return repo.save(publishing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Iterable<PublishingEntity> getAll() {
        return repo.findAll();
    }
}
