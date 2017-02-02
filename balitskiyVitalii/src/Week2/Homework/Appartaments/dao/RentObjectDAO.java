package Week2.Homework.Appartaments.dao;

import Week2.Homework.Appartaments.model.AppartamentsStorage;
import Week2.Homework.Appartaments.model.Flat;
import Week2.Homework.Appartaments.model.House;
import Week2.Homework.Appartaments.model.Room;

import java.util.Map;

/**
 * Created by vitalii on 01.02.17.
 */
public interface RentObjectDAO {

    Map<Long, Flat> getFlats(int offset);
    Map<Long, Room> getRooms(int offset);
    Map<Long, House> getHouses(int offset);

    Map<Long, Flat> addFlats(Flat...flats);
    Map<Long, Room> addRooms(Room...rooms);
    Map<Long, House> addHouses(House...houses);



}
