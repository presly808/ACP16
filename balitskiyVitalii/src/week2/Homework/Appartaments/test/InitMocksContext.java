package week2.Homework.Appartaments.test;

import week2.Homework.Appartaments.dao.JSONRentObjectDAO;
import week2.Homework.Appartaments.exceptions.InvalidFlatException;
import week2.Homework.Appartaments.exceptions.NoSuchRentObjectException;
import week2.Homework.Appartaments.model.AppartamentsStorage;
import week2.Homework.Appartaments.model.Flat;
import week2.Homework.Appartaments.model.House;
import week2.Homework.Appartaments.model.Room;
import week2.Homework.Appartaments.service.RentObjectServiceImpl;
import week2.Homework.Appartaments.utils.FlatFactory;
import week2.Homework.Appartaments.utils.HouseFactory;
import week2.Homework.Appartaments.utils.RoomFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;
import java.util.stream.Collectors;

import static org.mockito.Mockito.when;

/**
 * Created by vitalii on 02.02.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class InitMocksContext {

    @Mock
    public JSONRentObjectDAO objectDAO;
    @Mock
    public RentObjectServiceImpl rentObjectService;

    protected List<Flat> flats;
    protected Map<Long, Flat> flatMap;
    protected Map<Long, Room> rooms;
    protected Map<Long, House> houses;
    protected  List<Flat> flatList;
    protected List<Room> roomList;
    protected List<House> houseList;
    protected AppartamentsStorage storage;

    @Before
    public void setUp() throws InvalidFlatException {
        storage = new AppartamentsStorage();

        Flat flat1 = FlatFactory.createFlat();
        Flat flat2 = FlatFactory.createFlat();
        flats = new ArrayList<>();
        flats.add(flat1);
//        flats.put(flat2.getId(), flat2);
        flatMap = new HashMap<>();
        flatMap.put(flat1.getId(), flat1);

        House house = HouseFactory.createHouse();
        houses = new HashMap<>();
        houses.put(house.getId(), house);

        Room room = RoomFactory.createRoom();
        rooms = new HashMap<>();
        rooms.put(room.getId(), room);


        when(objectDAO.getFlats(0)).thenReturn(flatMap);
        when(objectDAO.getHouses(0)).thenReturn(houses);
        when(objectDAO.getRooms(0)).thenReturn(rooms);

        try {
            flatList = objectDAO.getFlats(0).entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
            roomList = objectDAO.getRooms(0).entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());
            houseList = objectDAO.getHouses(0).entrySet().stream().map(x -> x.getValue()).collect(Collectors.toList());

            when(rentObjectService.getFlats()).thenReturn(flatList);
            when(rentObjectService.getRooms()).thenReturn(roomList);
            when(rentObjectService.getHouses()).thenReturn(houseList);
        } catch (NoSuchRentObjectException e) {
            e.printStackTrace();
        }
    }

}
