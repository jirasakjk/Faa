package sut.se.g13.Entity;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@ToString
@EqualsAndHashCode
@Table(name="Parent")
public class Parents {
    @Id
    @SequenceGenerator(name="parents_seq",sequenceName="parents_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="parents_seq")
    private @NonNull Long id;
    @NotNull
    //@Pattern(regexp = "^([ก-ู]|[เ-์])+")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private @NonNull String name;
    public Parents(){}
    public Parents(String name){
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
