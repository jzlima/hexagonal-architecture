package com.baeldung.hexagonalarchitecture.application.dto;

import com.baeldung.hexagonalarchitecture.core.BookStore;
import lombok.Getter;
import lombok.Setter;

public class BookStoreDTO {

    @Getter
    @Setter
    String name="";

    public BookStoreDTO(BookStore bookStore) {
        this.name = bookStore.getName();
    }

    public BookStore toBookStore(){
        return new BookStore(this.name);
    }
}
