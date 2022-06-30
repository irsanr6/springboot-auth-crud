package com.elibrary.crudauth.presenter;

import com.elibrary.crudauth.entity.BookModel;
import com.elibrary.crudauth.dto.response.DataResponse;
import com.elibrary.crudauth.usecase.BookUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class BookPresenter {

    BookUseCase bookUseCase;


    @Autowired
    public BookPresenter(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBook( @RequestParam(required = false, value = "book_id") Long bookId) {
        if (bookId == null) {
            DataResponse bookModels = bookUseCase.getAllBooks();
            return ResponseEntity.ok().body(bookModels);
        } else {
            DataResponse bookModel = bookUseCase.getBookById(bookId);
            return ResponseEntity.ok().body(bookModel);
        }
    }

    @PostMapping("/books")
    public ResponseEntity<?> updateBook(@RequestBody BookModel bookModel, @RequestParam(required = false, value = "book_id") Long bookId) {
        DataResponse updBookModel = bookUseCase.updateBook(bookModel, bookId);
        return ResponseEntity.ok().body(updBookModel);
    }
}
