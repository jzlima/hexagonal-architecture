package com.baeldung.hexagonalarchitecture.core;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
public class Book {

	@Id
	@GeneratedValue
	@Getter
	private long id;

	@Column(nullable = false)
	@Getter
	@Setter
	private String title;

	@Column(nullable = false)
	@Getter
	@Setter
	private String author;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "Book_BookStore",
			joinColumns = {@JoinColumn(name = "bookstore_id")},
			inverseJoinColumns = {@JoinColumn(name = "book_id")}
	)
	@Getter
	@Setter
	private List<BookStore> bookStores;


	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}
}
