package org.adilet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.adilet.enums.Genre;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "book_gen" )
    @SequenceGenerator(
            name = "book_seq",
            sequenceName = "book_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String country;
    @Column(name = "publisher_year")
    private LocalDate publishedYear;
    private BigDecimal price;
    private Genre genre;


    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE,
                    CascadeType.DETACH
            }
    )
    private  Author author;
    @ManyToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE,
                    CascadeType.DETACH
            }
    )
    private Publisher publisher;

    public Book(String name, LocalDate publishedYear, BigDecimal price, Genre genre) {
        this.name = name;
        this.publishedYear = publishedYear;
        this.price = price;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", publishedYear=" + publishedYear +
                ", price=" + price +
                ", genre=" + genre +
                '}';
    }
}
