package com.elibrary.crudauth.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BookResponse {
    private Long bookId;
    private String bookName;
    private Long bookIsbn;
    private String bookAuthor;
    private String bookPublisher;
}
