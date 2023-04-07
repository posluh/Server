package ru.posluh.clientserver.libraryserver.response;

import ru.posluh.clientserver.libraryserver.entity.PublishingEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PublishingResponse extends BaseResponse {
    public PublishingResponse(boolean success, String message, PublishingEntity publishing) {
        super(success, message);
        this.publishing = publishing;
    }

    public PublishingResponse(PublishingEntity publishing) {
        super(true, "Publishing data:");
    }

    private PublishingEntity publishing;
}
