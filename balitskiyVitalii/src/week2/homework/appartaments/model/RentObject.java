package week2.homework.appartaments.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

/**
 * Created by vitalii on 01.02.17.
 */
public class RentObject {

    protected long id;
    protected String address;
    protected float square;
    protected String comments;
    protected Set<Accessory> accessories;
    protected District district;
    protected LocalDate creatingDate;
    protected LocalTime creatingTime;

    public RentObject() {
        creatingDate = LocalDate.now();
        creatingTime = LocalTime.now();
    }

    public RentObject(long id, String address, float square, String comments, Set<Accessory> accessories, District district) {
        this();
        this.id = id;
        this.address = address;
        this.square = square;
        this.comments = comments;
        this.accessories = accessories;
        this.district = district;
    }

    @Override
    public String toString() {
        return "RentObject{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", comments='" + comments + '\'' +
                ", accessories=" + accessories +
                ", district=" + district +
                ", creatingDate=" + creatingDate +
                ", creatingTime=" + creatingTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RentObject that = (RentObject) o;

        if (id != that.id) return false;
        if (Float.compare(that.square, square) != 0) return false;
        if (address != null ? !address.equals(that.address) : that.address != null) return false;
        if (comments != null ? !comments.equals(that.comments) : that.comments != null) return false;
        if (accessories != null ? !accessories.equals(that.accessories) : that.accessories != null) return false;
        if (district != that.district) return false;
        if (creatingDate != null ? !creatingDate.equals(that.creatingDate) : that.creatingDate != null) return false;
        return !(creatingTime != null ? !creatingTime.equals(that.creatingTime) : that.creatingTime != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (square != +0.0f ? Float.floatToIntBits(square) : 0);
        result = 31 * result + (comments != null ? comments.hashCode() : 0);
        result = 31 * result + (accessories != null ? accessories.hashCode() : 0);
        result = 31 * result + (district != null ? district.hashCode() : 0);
        result = 31 * result + (creatingDate != null ? creatingDate.hashCode() : 0);
        result = 31 * result + (creatingTime != null ? creatingTime.hashCode() : 0);
        return result;
    }

    public LocalDate getCreatingDate() {
        return creatingDate;
    }

    public void setCreatingDate(LocalDate creatingDate) {
        this.creatingDate = creatingDate;
    }

    public LocalTime getCreatingTime() {
        return creatingTime;
    }

    public void setCreatingTime(LocalTime creatingTime) {
        this.creatingTime = creatingTime;
    }

    public District getDistrict() {

        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public float getSquare() {
        return square;
    }

    public void setSquare(float square) {
        this.square = square;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Set<Accessory> getAccessories() {
        return accessories;
    }

    public void setAccessories(Set<Accessory> accessories) {
        this.accessories = accessories;
    }

}
