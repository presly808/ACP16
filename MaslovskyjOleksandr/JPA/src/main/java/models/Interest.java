package models;

import javax.persistence.*;

@Table (name = "interests")
@Entity
public class Interest {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private InterestsType type;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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
                "id=" + id +
                ", type=" + type +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Interest interest = (Interest) o;

        return id == interest.id;

    }

    @Override
    public int hashCode() {
        return (int) (id ^ (id >>> 32));
    }
}
