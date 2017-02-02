package Week2.Homework.Appartaments.dao;

import Week2.Homework.Appartaments.Model.AppartamentsStorage;
import Week2.Homework.Appartaments.Model.Flat;
import Week2.Homework.Appartaments.Model.House;
import Week2.Homework.Appartaments.Model.Room;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAO implements RentObjectDAO {

    private AppartamentsStorage storage;

    public JSONRentObjectDAO(AppartamentsStorage storage) {
        this.storage = storage;
    }

    @Override
    public AppartamentsStorage getFlats(int offset) {
        return null;
    }

    @Override
    public AppartamentsStorage getRooms(int offset) {
        return null;
    }

    @Override
    public AppartamentsStorage getHouses(int offset) {
        return null;
    }

    @Override
    public AppartamentsStorage addFlats(Flat... flats) {
        return null;
    }

    @Override
    public AppartamentsStorage addRooms(Room... rooms) {
        return null;
    }

    @Override
    public AppartamentsStorage addHouses(House... houses) {
        return null;
    }
}
