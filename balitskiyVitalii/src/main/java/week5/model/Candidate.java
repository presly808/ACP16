package week5.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Created by Vitalii on 25.02.2017.
 */
public class Candidate {

    private int id;
    private String fullname;
    private int age;
    private int region;

    public Candidate(int id, String fullname, int age, int region) {
        this.id = id;
        this.fullname = fullname;
        this.age = age;
        this.region = region;
    }

    @Override
    public boolean equals(Object o) {
        return EqualsBuilder.reflectionEquals(this, o);
    }

    @Override
    public int hashCode() {
        return HashCodeBuilder.reflectionHashCode(this);
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
