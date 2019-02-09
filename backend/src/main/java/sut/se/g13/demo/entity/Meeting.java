package sut.se.g13.demo.entity;

import lombok.*;
import javax.persistence.*;

@Entity
@ToString
@EqualsAndHashCode
public class Meeting {
    @Id
    @SequenceGenerator(name="Meeting_seq",sequenceName="Meeting_seq")
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="Meeting_seq")
    private @NonNull Long id;
    private String topic;
    private String descrip;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Personnel personnel;

    @ManyToOne
    private Statusmeet statusmeet;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Personnel getPersonnel() {
        return personnel;
    }

    public void setPersonnel(Personnel personnel) {
        this.personnel = personnel;
    }

    public Statusmeet getStatusmeet() {
        return statusmeet;
    }

    public void setStatusmeet(Statusmeet statusmeet) {
        this.statusmeet = statusmeet;
    }

    public Meeting(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Meeting(String topic){
        this.topic = topic;
    }


}
