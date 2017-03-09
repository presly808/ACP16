package models;

import java.util.List;

public class Interest extends IdGenerator{

    private List<Candidate > candidate;

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
