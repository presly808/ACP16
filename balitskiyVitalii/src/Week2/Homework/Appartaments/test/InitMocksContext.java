package Week2.Homework.Appartaments.test;

import Week2.Homework.Appartaments.dao.JSONRentObjectDAO;
import Week2.Homework.Appartaments.exceptions.InvalidFlatException;
import Week2.Homework.Appartaments.model.AppartamentsStorage;
import Week2.Homework.Appartaments.model.Flat;
import Week2.Homework.Appartaments.model.House;
import Week2.Homework.Appartaments.model.Room;
import Week2.Homework.Appartaments.utils.FlatFactory;
import Week2.Homework.Appartaments.utils.HouseFactory;
import Week2.Homework.Appartaments.utils.RoomFactory;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.when;

/**
 * Created by vitalii on 02.02.17.
 */
@RunWith(MockitoJUnitRunner.class)
public class InitMocksContext {

    @Mock
    public JSONRentObjectDAO objectDAO;

    protected Map<Long, Flat> flats;
    protected Map<Long, Room> rooms;
    protected Map<Long, House> houses;

    @Before
    public void setUp() throws InvalidFlatException {
        Flat flat = FlatFactory.createFlat();
        flats = new HashMap<>();
        flats.put(flat.getId(), flat);

        House house = HouseFactory.createHouse();
        houses = new HashMap<>();
        houses.put(house.getId(), house);

        Room room = RoomFactory.createRoom();
        rooms = new HashMap<>();
        rooms.put(room.getId(), room);


        when(objectDAO.getFlats(0)).thenReturn(flats);
        when(objectDAO.getHouses(0)).thenReturn(houses);
        when(objectDAO.getRooms(0)).thenReturn(rooms);
    }

}
