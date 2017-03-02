package week2.homework.appartaments.service;

import week2.homework.appartaments.exceptions.NoSuchRentObjectException;
import week2.homework.appartaments.model.Flat;
import week2.homework.appartaments.model.House;
import week2.homework.appartaments.model.Room;

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
