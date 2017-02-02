package Week2.Homework.Appartaments.test;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by vitalii on 01.02.17.
 */
public class JSONRentObjectDAOTest extends InitMocksContext {


    @Test
    public void getFlatsTest(){
        assertThat(flats, is(objectDAO.getFlats(0)));
    }

    @Test
    public void getHousesTest(){
        assertThat(houses, is(objectDAO.getHouses(0)));
    }

    @Test
    public void getRoomsTest(){
        assertThat(rooms, is(objectDAO.getRooms(0)));
    }
}

