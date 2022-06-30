package com.elibrary.crudauth.repo;

import com.elibrary.crudauth.entity.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <BookModel, Long> {
}
