package io.company.model;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;


@Getter @Setter @ToString
@Entity(name="RareBook")
@DiscriminatorValue(value= "REREBOOK")
public class RareBook extends Book{

    @Column(name="HAND_MADE")
    private boolean handMade;
    @Column(name="HAND_NUMBERED")
    private boolean handNumbered;
    @Column(name="numberCollection")
    private String numberCollection;
    @Column(name="COLLECTION")
    private boolean collection;

    //example: https://www.etsy.com/listing/927526995/daemonologie-by-king-james-rare-occu


    public RareBook(String title, int pages, int publishedYear, String isbn, boolean handMade, boolean handNumbered, String numberCollection, boolean collection) {
        super(title, pages, publishedYear, isbn);
        this.handMade = handMade;
        this.handNumbered = handNumbered;
        this.numberCollection = numberCollection;
        this.collection = collection;

    }

    public RareBook(){
        super();
    }
}
