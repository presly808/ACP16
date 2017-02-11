package Week2.Homework.Appartaments.service;

import Week2.Homework.Appartaments.exceptions.NoSuchRentObjectException;
import Week2.Homework.Appartaments.model.Flat;
import Week2.Homework.Appartaments.model.House;
import Week2.Homework.Appartaments.model.Room;

import java.util.List;

/**
 * Created by vitalii on 02.02.17.
 */
public interface RentObjectService {

    List<Flat> getFlats() throws NoSuchRentObjectException;
    List<Room> getRooms() throws NoSuchRentObjectException;
    List<House> getHouses() throws NoSuchRentObjectException;

    List<Flat> addFlats();
    List<Room> addRooms();
    List<House> addHouses();

}
