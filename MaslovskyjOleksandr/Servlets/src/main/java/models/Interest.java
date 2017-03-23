package models;

import javax.persistence.*;
import java.util.List;

@Table(name = "interests")
@Entity
public class Interest extends IdGenerator{

    @OneToMany(mappedBy = "interest")
    private List<Candidate > candidate;

    @Column(name = "type")
    private String type;

    public Interest() {
    }

    public Interest(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Interest{" +
                "id=" + getId() +
                ", type=" + type +
                '}';
    }

}
