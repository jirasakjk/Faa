package sut.se.g13.Entity;
import lombok.*;
import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.persistence.*;
@Entity
@ToString
@EqualsAndHashCode
@Table(name="Classrooms")
public class Classrooms {
    @Id
    @SequenceGenerator(name="classroom_seq",sequenceName="classroom_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="classroom_seq")
    private @NonNull Long id;
    @NotNull
  //  @Pattern(regexp = "[B]\\d{1}")
    @Size(min = 5 ,max = 20)
    @Column(unique = true)
    private String classroom;
    public Classrooms(){}
    public Classrooms(String classroom){
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClassroom() {
        return classroom;
    }

    public void setClassroom(String classroom) {
        this.classroom = classroom;
    }
}
