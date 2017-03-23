package models;

import javax.persistence.*;
import java.util.List;

@Table(name = "regions")
@Entity
public class Region extends IdGenerator{

    @OneToMany(mappedBy = "region")
    private List<Candidate > candidate;

    @Column(name = "region")
    private String regionType;

    public Region() {
    }

    public Region(String regionType) {
        this.regionType = regionType;
    }

    public String getRegionType() {
        return regionType;
    }

    public void setRegionType(String regionType) {
        this.regionType = regionType;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + getId() +
                ", regionType=" + regionType +
                '}';
    }
}
