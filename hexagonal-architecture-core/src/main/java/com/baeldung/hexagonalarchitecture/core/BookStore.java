package com.baeldung.hexagonalarchitecture.core;

import java.util.List;

import javax.persistence.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
public class BookStore {


	@Id
	@GeneratedValue
	@Getter
	private long id;
	
	@Column(nullable = false)
	@Getter
	@Setter
	private String name;


	@ManyToMany(mappedBy = "bookStores", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	@Getter
	@Setter
	private List<Book> books;


	public BookStore(String name) {
		this.name = name;
	}
}