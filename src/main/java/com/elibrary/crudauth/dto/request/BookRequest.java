package com.elibrary.crudauth.dto.request;

import lombok.Data;

@Data
public class BookRequest {
    private Long bookId;
    private String bookName;
    private Long bookIsbn;
    private String bookAuthor;
    private String bookPublisher;

}
