package week2.homework.appartaments.model;

import java.util.Set;

/**
 * Created by vitalii on 01.02.17.
 */
public class Flat extends RentObject {

    private int roomsCount;
    private boolean communRoom;
    private int floor;


    public Flat(long id, String address, float square, String comments, Set<Accessory>accessories, District district) {
        super(id, address, square, comments, accessories, district);
    }

    public Flat(int roomsCount, boolean communRoom, long id, String address, float square, String comments, Set<Accessory>accessories, District district, int floor) {
        this(id, address, square, comments, accessories, district);
        this.roomsCount = roomsCount;
        this.communRoom = communRoom;
        this.floor = floor;
    }

    public Flat(){
        super();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Flat flat = (Flat) o;

        if (roomsCount != flat.roomsCount) return false;
        if (communRoom != flat.communRoom) return false;
        return floor == flat.floor;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + roomsCount;
        result = 31 * result + (communRoom ? 1 : 0);
        result = 31 * result + floor;
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", square=" + square +
                ", comments='" + comments + '\'' +
                ", accessories=" + accessories +
                ", district=" + district +
                ", creatingDate=" + creatingDate +
                ", creatingTime=" + creatingTime +
                "roomsCount=" + roomsCount +
                ", communRoom=" + communRoom +
                '}';
    }

    public int getRoomsCount() {
        return roomsCount;
    }

    public void setRoomsCount(int roomsCount) {
        this.roomsCount = roomsCount;
    }

    public boolean isCommunRoom() {
        return communRoom;
    }

    public void setCommunRoom(boolean communRoom) {
        this.communRoom = communRoom;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }
}
