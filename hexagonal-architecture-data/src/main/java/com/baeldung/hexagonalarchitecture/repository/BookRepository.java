package com.baeldung.hexagonalarchitecture.repository;


import com.baeldung.hexagonalarchitecture.core.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends CrudRepository<Book,Long> {
      Book findByTitle(String title);
      List<Book> findByAuthor(String author);
}
