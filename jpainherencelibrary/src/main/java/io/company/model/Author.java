package io.company.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity(name="Author")
@Table(name="AUTHOR_TABLE")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="AUTHOR_ID")
    private  long authorId;
    @Column(name="FIRST_NAME")
    private String firstName;
    @Column(name="LAST_NAME")
    private String lastName;
    @Column(name = "DATE_OF_BIRTH", columnDefinition = "DATE")
    private LocalDate dob;

    @ManyToMany(mappedBy = "authors", cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private Set<Book> books = new HashSet<Book>();

    //constructor without ID
    public Author(String firstName, String lastName, LocalDate dob){
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }


}