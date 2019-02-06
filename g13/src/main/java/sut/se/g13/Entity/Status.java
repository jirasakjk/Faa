package sut.se.g13.Entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Data
@ToString
@EqualsAndHashCode
@Table(name="status")

public class Status {

    @Id
    @SequenceGenerator(name="status_seq",sequenceName="status_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="status_seq")
    @Column(name="STATUS_ID",unique = true, nullable = true)
    private @NonNull Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStstusname() {
        return ststusname;
    }

    public void setStstusname(String ststusname) {
        this.ststusname = ststusname;
    }

    @NotNull
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private  String ststusname;

    public Status (){}
    public Status (String ststusname){
        this.ststusname = ststusname;
    }

}
