package models;

import javax.persistence.*;
import java.util.List;

@Table(name = "interests")
@Entity
public class Interest extends IdGenerator{

    @OneToMany(mappedBy = "interest")
    private List<Candidate > candidate;

    @Enumerated(EnumType.STRING)
    private InterestsType type;

    public Interest() {
    }

    public Interest(InterestsType type) {
        this.type = type;
    }

    public InterestsType getType() {
        return type;
    }

    public void setType(InterestsType type) {
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
