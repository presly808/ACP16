package week2.homework.appartaments.dao;

import week2.homework.appartaments.model.Flat;
import week2.homework.appartaments.model.House;
import week2.homework.appartaments.model.Room;

import java.util.List;
import java.util.Map;

/**
 * Created by vitalii on 01.02.17.
 */
public interface RentObjectDAO {

    Map<Long, Flat> getFlats(int offset);
    Map<Long, Room> getRooms(int offset);
    Map<Long, House> getHouses(int offset);

    List<Flat> addFlats(List<Flat> flats);
    List<Room> addRooms(List<Room> rooms);
    List<House> addHouses(List<House> houses);



}
