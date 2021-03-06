package week2.homework.appartaments.model;

import java.util.Set;

/**
 * Created by vitalii on 01.02.17.
 */
public class Room extends RentObject {

    private boolean communRoom;

    public Room(long id, String address, float square, String comments, Set<Accessory> accessories, District district) {
        super(id, address, square, comments, accessories, district);
    }

    public Room(long id, String address, float square, String comments, Set<Accessory> accessories, District district, boolean communRoom) {
        this(id, address, square, comments, accessories, district);
        this.communRoom = communRoom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Room room = (Room) o;

        return communRoom == room.communRoom;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (communRoom ? 1 : 0);
        return result;
    }

    public boolean isCommunRoom() {
        return communRoom;
    }

    public void setCommunRoom(boolean communRoom) {
        this.communRoom = communRoom;
    }

    @Override
    public String toString() {
        return "Room{" +
                "communRoom=" + communRoom +
                '}';
    }
}
