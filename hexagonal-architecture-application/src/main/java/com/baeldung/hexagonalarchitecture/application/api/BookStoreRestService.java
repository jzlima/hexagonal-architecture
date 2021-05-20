package com.baeldung.hexagonalarchitecture.application.api;

import com.baeldung.hexagonalarchitecture.application.dto.BookDTO;
import com.baeldung.hexagonalarchitecture.application.dto.BookStoreDTO;
import com.baeldung.hexagonalarchitecture.core.Book;
import com.baeldung.hexagonalarchitecture.core.BookStore;
import com.baeldung.hexagonalarchitecture.repository.BookStoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/bookstore")
public class BookStoreRestService {
    @Autowired
    BookStoreRepository bookStoreRepository;

    @GetMapping("/all")
    public List<BookStoreDTO> listAllBookStores() {
        Iterable<BookStore> list = bookStoreRepository.findAll();
        return StreamSupport.stream(list.spliterator(), false).
                map(BookStoreDTO::new).collect(toList());
    }

    @GetMapping("/{id}")
    public BookStoreDTO listBookStoreById(@PathVariable Integer  id) {
        Optional<BookStore> bookStore = bookStoreRepository.findById(id.longValue());
        return new BookStoreDTO(bookStore.orElseGet(BookStore::new));
    }

    @GetMapping("/{id}/books")
    public List<BookDTO> listAllBooksFromBookStores(@PathVariable Integer  id) {
        Optional<BookStore> bookStore = bookStoreRepository.findById(id.longValue());
        List<Book> listBookStore = bookStore.orElseGet(BookStore::new).getBooks();
        return listBookStore.stream().
                map(BookDTO::new).collect(toList());
    }
}
