package io.company.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;

@Getter @Setter @ToString
@Entity(name="ItemBook")
@PrimaryKeyJoinColumn(name = "bookItemId")
@DiscriminatorValue(value= "ITEMBOOK")
public class ItemBook extends Book {

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


    public ItemBook(String title, int pages, int publishedYear, String isbn, Enum status, LocalDate borrowedDate, LocalDate dueDate, int loanPeriod, int overDueDaysQty) {
        super(title, pages, publishedYear, isbn);
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.dueDate = dueDate;
        this.loanPeriod = loanPeriod;
        this.overDueDaysQty = overDueDaysQty;
    }

    public ItemBook(){
        super();
    }
}

