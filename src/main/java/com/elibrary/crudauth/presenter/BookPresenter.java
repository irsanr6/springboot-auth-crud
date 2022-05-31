package com.elibrary.crudauth.presenter;

import com.elibrary.crudauth.dao.BookModel;
import com.elibrary.crudauth.usecase.BookUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BookPresenter {

    BookUseCase bookUseCase;


    @Autowired
    public BookPresenter(BookUseCase bookUseCase) {
        this.bookUseCase = bookUseCase;
    }

    @GetMapping("/books")
    public List<BookModel> getAllBook() {
        return bookUseCase.getAllBooks();
    }

    @GetMapping("/books/{book_id}")
    public ResponseEntity<BookModel> getBookById(@PathVariable("book_id") long bookId) {
        return bookUseCase.findBookById(bookId);
    }

    @PostMapping("/books")
    public ResponseEntity<BookModel> addBook(@RequestBody BookModel bookModel) {
        return bookUseCase.addBookrecord(bookModel);
    }

    @PutMapping("books/{book_id}")
    public BookModel updateBook(@RequestBody BookModel bookModel, @PathVariable("book_id") long bookId) {
        return bookUseCase.updateBook(bookModel, bookId);
    }
}
