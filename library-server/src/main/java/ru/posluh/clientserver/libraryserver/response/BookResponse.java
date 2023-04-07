package ru.posluh.clientserver.libraryserver.response;

import ru.posluh.clientserver.libraryserver.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookResponse extends BaseResponse {

    public BookResponse(boolean success, String message, BookEntity data) {
        super(success, message);
        this.data = data;
    }

    private BookEntity data;
}
