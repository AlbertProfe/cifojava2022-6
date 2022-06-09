package io.company.model;

//https://projectlombok.org/features/all
import lombok.*;
import javax.persistence.*;

@Getter @Setter @ToString
@Entity(name="PocketItemBook")
@DiscriminatorValue(value= "POCKETBOOK")
public class PocketItemBook extends ItemBook{

    @Column(name="SIZE")
    private String size;

    public PocketItemBook(){
        super();

    }


}
