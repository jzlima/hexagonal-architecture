package com.baeldung.hexagonalarchitecture.application.dto;

import com.baeldung.hexagonalarchitecture.core.Book;
import lombok.Getter;
import lombok.Setter;

public class BookDTO {
    @Getter
    @Setter
    String title="";

    @Getter
    @Setter
    String autor="";

    public BookDTO(Book book) {
        this.title = book.getTitle();
        this.autor = book.getAuthor();
    }

    public BookDTO() {
    }


    public Book toBook(){
        return new Book(this.title, this.autor);
    }
}
