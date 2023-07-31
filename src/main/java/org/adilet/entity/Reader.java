package org.adilet.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Reader {
    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "reader_gen")
    @SequenceGenerator(
            name = "reader_gen",
            sequenceName = "reader_seq",
            allocationSize = 1
    )
    private Long id;
    private String name;
    private String email;
    @OneToOne(
            cascade = {
                    CascadeType.PERSIST,
                    CascadeType.MERGE,
                    CascadeType.REFRESH,
                    CascadeType.REMOVE,
                    CascadeType.DETACH
            }
    )
    private Book book;

    public Reader(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
