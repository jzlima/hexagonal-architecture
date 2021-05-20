package com.baeldung.hexagonalarchitecture.application.api;

import com.baeldung.hexagonalarchitecture.application.dto.BookDTO;
import com.baeldung.hexagonalarchitecture.application.dto.BookStoreDTO;
import com.baeldung.hexagonalarchitecture.core.Book;
import com.baeldung.hexagonalarchitecture.core.BookStore;
import com.baeldung.hexagonalarchitecture.repository.BookRepository;
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
@RequestMapping("/book")
public class BookRestService {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("/all")
    public List<BookDTO> listAllBooks() {
        Iterable<Book> list = bookRepository.findAll();
        return StreamSupport.stream(list.spliterator(),false).
                map(BookDTO::new).collect(toList());
    }

    @GetMapping("/{id}")
    public BookDTO listBookById(@PathVariable Integer  id) {
        Optional<Book> book = bookRepository.findById(id.longValue());
        return new BookDTO(book.orElseGet(Book::new));
    }

    @GetMapping("/{id}/bookstores")
    public List<BookStoreDTO> listAllBooksStores(@PathVariable Integer  id) {
        Optional<Book> book = bookRepository.findById(id.longValue());
        List<BookStore> listBookStore = book.orElseGet(Book::new).getBookStores();
        return listBookStore.stream().
                map(BookStoreDTO::new).collect(toList());
    }
}
