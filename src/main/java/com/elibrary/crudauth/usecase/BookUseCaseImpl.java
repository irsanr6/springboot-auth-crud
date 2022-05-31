package com.elibrary.crudauth.usecase;

import com.elibrary.crudauth.dao.BookModel;
import com.elibrary.crudauth.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
public class BookUseCaseImpl implements BookUseCase {

    @Autowired
    BookRepository bookRepository;


    @Override
    public ResponseEntity<BookModel> findBookById(long bookId) {
        Optional<BookModel> bookModel = bookRepository.findById(bookId);
        if (bookModel.isPresent()) {
            return new ResponseEntity<>(bookModel.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<BookModel> addBookrecord(BookModel bookModel) {
        try {
            BookModel model = bookRepository
                    .save(bookModel);
            return new ResponseEntity<>(model, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public List<BookModel> getAllBooks() {

        return bookRepository.findAll();
    }

    @Override
    public BookModel updateBook(BookModel bookModel, long bookId) {
        BookModel model
                = bookRepository.findById(bookId)
                .get();

        if (Objects.nonNull(bookModel.getBookName())
                && !"".equalsIgnoreCase(
                bookModel.getBookName())) {
            model.setBookName(
                    bookModel.getBookName());
        }

        if (Objects.nonNull(
                bookModel.getBookIsbn())
                && !"".equalsIgnoreCase(
                String.valueOf(bookModel.getBookIsbn()))) {
            model.setBookIsbn(
                    bookModel.getBookIsbn());
        }

        if (Objects.nonNull(bookModel.getBookAuthor())
                && !"".equalsIgnoreCase(
                bookModel.getBookAuthor())) {
            model.setBookAuthor(
                    bookModel.getBookAuthor());
        }

        if (Objects.nonNull(bookModel.getBookPublisher())
                && !"".equalsIgnoreCase(
                bookModel.getBookPublisher())) {
            model.setBookPublisher(
                    bookModel.getBookPublisher());
        }

        return bookRepository.save(model);
    }
}
