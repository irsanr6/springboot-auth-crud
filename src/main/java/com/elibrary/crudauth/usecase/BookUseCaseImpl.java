package com.elibrary.crudauth.usecase;

import com.elibrary.crudauth.dto.response.DataResponse;
import com.elibrary.crudauth.entity.BookModel;
import com.elibrary.crudauth.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BookUseCaseImpl implements BookUseCase {

    @Autowired
    BookRepository bookRepository;

    @Override
    public DataResponse getAllBooks() {
        List<BookModel> bookModels = bookRepository.findAll();
        if (bookModels.isEmpty()) {
            return DataResponse.builder()
                    .status(false)
                    .message("No Data")
                    .data(null)
                    .build();
        }
        return DataResponse.builder()
                .status(true)
                .message("Success")
                .data(bookModels)
                .build();
    }

    @Override
    public DataResponse getBookById(Long bookId) {
        Optional<BookModel> optBookModel = bookRepository.findById(bookId);
        if (optBookModel.isEmpty()) {
            return DataResponse.builder()
                    .status(false)
                    .message("Data Not Found")
                    .data(null)
                    .build();
        }
        return DataResponse.builder()
                .status(true)
                .message("Success")
                .data(optBookModel)
                .build();
    }

    @Override
    public DataResponse updateBook(BookModel bookModel, Long bookId) {
        if (bookId != null) {
            Optional<BookModel> updBookModel = bookRepository.findById(bookId);
            if (updBookModel.isPresent()) {
                BookModel getBookModel = updBookModel.get();
                getBookModel.setBookName(bookModel.getBookName());
                getBookModel.setBookAuthor(bookModel.getBookAuthor());
                getBookModel.setBookPublisher(bookModel.getBookPublisher());
                getBookModel.setBookIsbn(bookModel.getBookIsbn());
                BookModel book = bookRepository.save(getBookModel);
                return DataResponse.builder()
                        .status(true)
                        .message("Success")
                        .data(book)
                        .build();
            }
        }
        BookModel book = bookRepository.save(bookModel);
        return DataResponse.builder()
                .status(true)
                .message("Success")
                .data(book)
                .build();
    }
}
