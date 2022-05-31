package com.elibrary.crudauth.usecase;

import com.elibrary.crudauth.dao.BookModel;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface BookUseCase {

    ResponseEntity<BookModel> findBookById(long bookId);

    ResponseEntity<BookModel> addBookrecord(BookModel bookModel);

    List<BookModel> getAllBooks();

    BookModel updateBook(BookModel bookModel, long bookId);
}
