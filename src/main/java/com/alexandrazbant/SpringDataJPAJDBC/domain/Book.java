package com.alexandrazbant.SpringDataJPAJDBC.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String isbn;
    private String publisher;
    @Transient
    private Author authorId;


    public Book(String title, String isbn, String publisher, Author author) {
        this.title = title;
        this.isbn = isbn;
        this.publisher = publisher;
        this.authorId = author;
    }
}


