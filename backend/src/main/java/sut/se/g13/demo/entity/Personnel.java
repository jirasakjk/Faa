package sut.se.g13.demo.entity;

import lombok.Data;
import lombok.NonNull;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Data
@Entity
@Table(name = "Personnel")
public class Personnel {
    @Id
    @SequenceGenerator(name="Personnel",sequenceName="Personnel_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Personnel_seq")
    private @NonNull Long id;
    private String pname;

    public Personnel(){
    }
    public Personnel(String pname){
        this.pname = pname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
