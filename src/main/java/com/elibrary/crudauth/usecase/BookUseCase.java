package com.elibrary.crudauth.usecase;

import com.elibrary.crudauth.dto.response.DataResponse;
import com.elibrary.crudauth.entity.BookModel;


public interface BookUseCase {

    DataResponse getAllBooks();
    
    DataResponse getBookById(Long bookId);

    DataResponse updateBook(BookModel bookModel, Long bookId);
}
