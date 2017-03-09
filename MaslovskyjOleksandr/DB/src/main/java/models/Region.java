package models;

import java.util.List;

public class Region extends IdGenerator{

    private List<Candidate > candidate;

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
