package ru.posluh.clientserver.libraryserver.response;

import ru.posluh.clientserver.libraryserver.entity.BookEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class BookListResponse extends BaseResponse {
    public BookListResponse(Iterable<BookEntity> data) {
        super(true, "Список книг");
        this.data = data;
    }

    private Iterable<BookEntity> data;
}