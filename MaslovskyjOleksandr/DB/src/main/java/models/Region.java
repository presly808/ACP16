package models;

import javax.persistence.*;
import java.util.List;

@Table(name = "regions")
@Entity
public class Region extends IdGenerator{

    @OneToMany(mappedBy = "region")
    private List<Candidate > candidate;

    @Enumerated(EnumType.STRING)
    private RegionType regionType;

    public Region() {
    }

    public Region(RegionType regionType) {
        this.regionType = regionType;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
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
