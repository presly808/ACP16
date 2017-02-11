package week2.Homework.Appartaments.model;

import week2.Homework.Appartaments.exceptions.InvalidFlatException;
import week2.Homework.Appartaments.exceptions.InvalidHouseException;
import week2.Homework.Appartaments.exceptions.InvalidRoomException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by vitalii on 01.02.17.
 */
public class AppartamentsStorage {

    private Map<Long, Flat> flats;
    private Map<Long, House> houses;
    private Map<Long, Room> rooms;

    public AppartamentsStorage() {
        flats = new HashMap<>();
        rooms = new HashMap<>();
        houses = new HashMap<>();
    }

    public void addFlat(Flat...flats) throws InvalidFlatException {
        for(Flat flat : flats) {
            this.flats.put(flat.getId(), flat);
        }
    }

    public void addRoom(Room...rooms) throws InvalidRoomException {
        for(Room room : rooms) {
            this.rooms.put(room.getId(), room);
        }
    }

    public void addHouse(House...houses) throws InvalidHouseException {
        for(House house : houses) {
            House addedHouse = this.houses.put(house.getId(), house);
        }
    }
}
