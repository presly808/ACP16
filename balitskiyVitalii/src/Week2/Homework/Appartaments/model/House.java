package Week2.Homework.Appartaments.model;

/**
 * Created by vitalii on 01.02.17.
 */
public class House extends RentObject {

    private int floors;
    private float houseTerritory;

    public House() {
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public float getHouseTerritory() {
        return houseTerritory;
    }

    public void setHouseTerritory(float houseTerritory) {
        this.houseTerritory = houseTerritory;
    }

    @Override
    public String toString() {
        return "House{" +
                "floors=" + floors +
                ", houseTerritory=" + houseTerritory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        House house = (House) o;

        if (floors != house.floors) return false;
        return Float.compare(house.houseTerritory, houseTerritory) == 0;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + floors;
        result = 31 * result + (houseTerritory != +0.0f ? Float.floatToIntBits(houseTerritory) : 0);
        return result;
    }
}
