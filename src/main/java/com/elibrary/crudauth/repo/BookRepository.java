package com.elibrary.crudauth.repo;

import com.elibrary.crudauth.dao.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository <BookModel, Long> {
}
