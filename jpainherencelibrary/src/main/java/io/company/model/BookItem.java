package io.company.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @ToString
@Entity(name="BookItem")
@Table(name="BOOK_ITEM_TABLE")
public class BookItem extends Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="BOOK_ITEM_ID")
    private long bookItemId;
    @Column(name="STATUS")
    private Enum status;
    @Column(name="BORROWED_DATE")
    private LocalDate borrowedDate;
    @Column(name="DUE_DATE")
    private LocalDate dueDate;
    @Column(name="LOAN_PERIOD")
    private int loanPeriod;
    @Column(name="OVER_DUE_DAYS_QTY")
    private int overDueDaysQty;



    //example https://www.oleanlibrary.org/about/library-card/due-dates-and-loan-periods
}

