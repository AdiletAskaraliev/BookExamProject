package org.adilet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.adilet.enums.Gender;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
public class Author {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "author_gen")
    @SequenceGenerator(
            name = "author_gen",
            sequenceName = "author_seq",
            allocationSize = 1
    )
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    private String country;
    private Gender gender;

    @ManyToMany(mappedBy = "authors",
            cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REFRESH,
            CascadeType.REMOVE,
            CascadeType.DETACH
    })
    private List<Publisher> publishers;

    @OneToMany(mappedBy = "author",
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE,
                    CascadeType.DETACH
            })
    private List<Book> books;


    public Author(String firstName, String lastName, String email, LocalDate dateOfBirth, String country, Gender gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.country = country;
        this.gender = gender;
    }

    public void setPublisher(Publisher publisher){
        if (this.publishers == null){
            this.publishers = new ArrayList<>();
        }
        publishers.add(publisher);
    }

    @Override
    public String toString() {
        return "Author{" +
                "firstName='" + firstName +
                ", lastName='" + lastName +
                ", email='" + email +
                ", dateOfBirth=" + dateOfBirth +
                ", country='" + country +
                ", gender=" + gender +
                '}';
    }
}
