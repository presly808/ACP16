package Week2.Homework.Appartaments.dao;

import Week2.Homework.Appartaments.Model.AppartamentsStorage;
import Week2.Homework.Appartaments.Model.Flat;
import Week2.Homework.Appartaments.Model.House;
import Week2.Homework.Appartaments.Model.Room;

/**
 * Created by vitalii on 01.02.17.
 */
public interface RentObjectDAO {

    AppartamentsStorage getFlats(int offset);
    AppartamentsStorage getRooms(int offset);
    AppartamentsStorage getHouses(int offset);

    AppartamentsStorage addFlats(Flat...flats);
    AppartamentsStorage addRooms(Room...rooms);
    AppartamentsStorage addHouses(House...houses);



}
