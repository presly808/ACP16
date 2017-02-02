package Week2.Homework.Appartaments.model;

/**
 * Created by vitalii on 01.02.17.
 */
public class Flat extends RentObject {

    private int roomsCount;
    private boolean communRoom;

    public Flat() {
        super();
    }

    public Flat(int roomsCount, boolean communRoom) {
        super();
        this.roomsCount = roomsCount;
        this.communRoom = communRoom;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Flat flat = (Flat) o;

        if (roomsCount != flat.roomsCount) return false;
        return communRoom == flat.communRoom;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + roomsCount;
        result = 31 * result + (communRoom ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Flat{" +
                "roomsCount=" + roomsCount +
                ", communRoom=" + communRoom +
                '}';
    }
}
