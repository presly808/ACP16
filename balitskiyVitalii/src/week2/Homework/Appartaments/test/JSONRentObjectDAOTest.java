package week2.homework.appartaments.test;

import week2.homework.appartaments.dao.JSONRentObjectDAO;
import week2.homework.appartaments.dao.RentObjectDAO;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAOTest extends InitMocksContext {


    @Test
    public void getFlatsTest(){
        assertThat(flatMap, is(objectDAO.getFlats(0)));
    }

    @Test
    public void getHousesTest(){
        assertThat(houses, is(objectDAO.getHouses(0)));
    }

    @Test
    public void getRoomsTest(){
        assertThat(rooms, is(objectDAO.getRooms(0)));
    }

    @Test
    public void addFlatsToJsonTest(){

        RentObjectDAO objectDAO = new JSONRentObjectDAO(storage);
        assertThat(flats, is(objectDAO.addFlats(flats)));
    }

    @Test
    public void getFlatsFromJsonTest(){
        RentObjectDAO objectDAO = new JSONRentObjectDAO(storage);
        assertThat(flatMap, is(objectDAO.getFlats(1)));
    }
}

