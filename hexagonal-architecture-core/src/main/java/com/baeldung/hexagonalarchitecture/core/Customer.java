package com.baeldung.hexagonalarchitecture.core;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
public class Customer {

    @Id
    @GeneratedValue
    @Getter
    private long id;


    @Column(nullable = false)
    @Getter
    @Setter
    private String name;

    @OneToMany
    @Getter
    @Setter
    private List<Book> bookshelf;


}
