package models;

import javax.persistence.*;

@Table(name = "regions")
@Entity
public class Region {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Enumerated(EnumType.STRING)
    private RegionType regionType;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public RegionType getRegionType() {
        return regionType;
    }

    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (id != region.id) return false;
        return regionType == region.regionType;

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (regionType != null ? regionType.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Region{" +
                "id=" + id +
                ", regionType=" + regionType +
                '}';
    }
}
