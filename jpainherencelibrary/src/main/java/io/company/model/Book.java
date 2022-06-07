package io.company.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@ToString
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false, nullable = false)
    private Long id;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "PAGES")
    private int pages;
    @Column(name="PUBLISHED_YEAR")
    private int publishedYear;
    @Column(name="ISBN")
    private String isbn;

    @ManyToMany(mappedBy = "books", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Author> authors = new HashSet<Author>();


    public Book(String title, int pages, int publishedYear, String isbn) {
        this.title = title;
        this.pages = pages;
        this.publishedYear = publishedYear;
        this.isbn = isbn;
    }

    public Book() {
    }


}
