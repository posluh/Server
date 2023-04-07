package ru.posluh.clientserver.libraryserver.response;

import ru.posluh.clientserver.libraryserver.entity.AuthorEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AuthorListResponse extends BaseResponse {
    public AuthorListResponse(Iterable<AuthorEntity> data) {
        super(true, "Authors:");
        this.data = data;
    }

    private Iterable<AuthorEntity> data;
}