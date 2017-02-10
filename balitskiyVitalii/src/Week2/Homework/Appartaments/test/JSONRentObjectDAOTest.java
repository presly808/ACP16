package Week2.Homework.Appartaments.test;

import Week2.Homework.Appartaments.dao.JSONRentObjectDAO;
import Week2.Homework.Appartaments.dao.RentObjectDAO;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Test;

import java.util.Collections;
import java.util.stream.Collectors;

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

