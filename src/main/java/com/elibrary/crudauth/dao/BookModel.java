package com.elibrary.crudauth.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "book_store")
@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class BookModel {
    @Id
    @Column(name = "book_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @Column(name = "book_name", length = 200)
    private String bookName;

    @Column(name = "book_isbn", length = 20)
    private Long bookIsbn;

    @Column(name = "book_author", length = 50)
    private String bookAuthor;

    @Column(name = "book_publisher", length = 50)
    private String bookPublisher;

}
