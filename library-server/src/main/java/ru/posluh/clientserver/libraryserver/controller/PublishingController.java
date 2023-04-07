package ru.posluh.clientserver.libraryserver.controller;

import ru.posluh.clientserver.libraryserver.entity.BookEntity;
import ru.posluh.clientserver.libraryserver.entity.PublishingEntity;
import ru.posluh.clientserver.libraryserver.response.BaseResponse;
import ru.posluh.clientserver.libraryserver.response.PublishingListResponse;
import ru.posluh.clientserver.libraryserver.response.PublishingResponse;
import ru.posluh.clientserver.libraryserver.service.PublishingService;
import ru.posluh.clientserver.libraryserver.utils.ValidationPublishingUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/publishing")
public class PublishingController {
    private final PublishingService service;

    public PublishingController(PublishingService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<BaseResponse> getAll() {
        return ResponseEntity.ok(new PublishingListResponse(service.getAll()));
    }

    @PostMapping("/add")
    public ResponseEntity<PublishingResponse> registrationAuthor(@RequestBody PublishingEntity data) {
        try {
            ValidationPublishingUtils.validationPublishing(data);
            PublishingEntity publishing = service.save(data);
            return ResponseEntity.ok(new PublishingResponse(true, "Издательство добавлено", publishing));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new PublishingResponse(false, e.getMessage(), null));
        }
    }

    @PostMapping("/update")
    public ResponseEntity<BaseResponse> update(@RequestBody PublishingEntity data) {
        try {
            service.save(data);
            return ResponseEntity.ok(new BaseResponse(true, "Информация о книге была обновлена"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BaseResponse> delete(@PathVariable Long id) {
        try {
            service.delete(id);
            return ResponseEntity.ok(new BaseResponse(true, "Издательство удалено"));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new BaseResponse(false, e.getMessage()));
        }
    }
}
