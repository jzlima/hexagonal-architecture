package com.baeldung.hexagonalarchitecture.repository;


import com.baeldung.hexagonalarchitecture.core.BookStore;
import org.springframework.data.repository.CrudRepository;

public interface BookStoreRepository extends CrudRepository<BookStore, Long> {

}
