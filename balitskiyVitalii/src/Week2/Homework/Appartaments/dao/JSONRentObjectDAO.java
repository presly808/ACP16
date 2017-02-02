package Week2.Homework.Appartaments.dao;

import Week2.Homework.Appartaments.model.AppartamentsStorage;
import Week2.Homework.Appartaments.model.Flat;
import Week2.Homework.Appartaments.model.House;
import Week2.Homework.Appartaments.model.Room;

import java.util.Map;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAO implements RentObjectDAO {

    private AppartamentsStorage storage;

    public JSONRentObjectDAO(AppartamentsStorage storage) {
        this.storage = storage;
    }

    @Override
    public Map<Long, Flat> getFlats(int offset) {
        return null;
    }

    @Override
    public Map<Long, Room> getRooms(int offset) {
        return null;
    }

    @Override
    public Map<Long, House> getHouses(int offset) {
        return null;
    }

    @Override
    public Map<Long, Flat> addFlats(Flat... flats) {
        return null;
    }

    @Override
    public Map<Long, Room> addRooms(Room... rooms) {
        return null;
    }

    @Override
    public Map<Long, House> addHouses(House... houses) {
        return null;
    }
}
